package edu.franklin.dataaccess;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;


@SuppressWarnings("rawtypes")
public abstract class BaseORM {
	private static final String QUOTED_PARAM = "'%s'";
	private interface IParameterFormater{
		String format(Object value);
	}
	private static HashMap<Class,IParameterFormater> paramFormat;
	static{
		paramFormat = new HashMap<Class,IParameterFormater>();
		paramFormat.put(String.class, new IParameterFormater(){
			@Override
			public String format(Object value) {
				return String.format(QUOTED_PARAM, value);
			}});
		paramFormat.put(Date.class, new IParameterFormater(){
			@Override
			public String format(Object value) {
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat fmtr = new SimpleDateFormat(pattern);
				return String.format(QUOTED_PARAM, fmtr.format(value));
			}});
	}
	
	private static String formatParameter(Class type,Object value){
		String paramString = "";
		if(paramFormat.containsKey(type)){
			paramString=paramFormat.get(type).format(value);
		}else{
			paramString = value.toString();
		}
		return paramString;
	}
	
	public String getUpdate() throws IllegalAccessException, InvocationTargetException{
		String t = this.getClass().getSimpleName().toLowerCase();
		HashMap<String, Object> CandV = extractColumnsValues();
		HashMap<String, Object> PKCandV = extractKeysValues();
		String sql = update(t);
		int c = 0;
		for(Entry<String, Object> e:CandV.entrySet()){
			if(null != e.getValue()){
				if(c==0)sql += "SET ";
				if(c>0) sql+=",";
				sql+=e.getKey()+"="+formatParameter(e.getValue().getClass(), e.getValue());
				c++;			
			}
		}
		
		c = 0;
		for(Entry<String, Object> e:PKCandV.entrySet()){
			if(c==0)sql += " WHERE ";
			//if(c>0) sql+=" AND";
			sql+=e.getKey()+"="+formatParameter(e.getValue().getClass(), e.getValue());
			c++;
		}
		return sql+";";
	}
	
	private HashMap<String, Object> extractKeysValues() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		HashMap<String,Object> PKCandV = new HashMap<String,Object>();
		for(Method f : this.getClass().getDeclaredMethods()){
			if(null!=f.getAnnotation(KeyColumn.class)){
				String c = ((KeyColumn)f.getAnnotation(KeyColumn.class)).name();
				Object v = f.invoke(this,(Object[])null);
				PKCandV.put(c, v);
			}
		}
		return PKCandV;
	}

	public String getDelete() throws Exception{
		String sql = "DELETE FROM "+this.getClass().getSimpleName().toLowerCase();
		HashMap<String, Object> PKCandV = extractKeysValues();
		int c = 0;
		for(Entry<String, Object> e:PKCandV.entrySet()){
			if(null != e.getValue()){
				if(c==0)sql += " WHERE ";
				//if(c>0) sql+=" AND";
				sql+=e.getKey()+"="+formatParameter(e.getValue().getClass(), e.getValue());
				c++;
			}

		}
		if(0 == c){ // no key parameters.  throw exception.
			throw new Exception("no parameters found for DELETE statement.");
		}
		sql += ";";
		return sql;
	}
	
	public String getInsert() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		String t = this.getClass().getSimpleName();
		HashMap<String, Object> CandV = extractColumnsValues();
		String sqlC = String.format("INSERT INTO %s(",t.toLowerCase());
		String sqlV = "VALUES(";
		
		int colCount = 0;
		for(Entry<String, Object> e:CandV.entrySet()){
			if(null != e.getValue()){
				if(colCount>0){sqlC+=",";sqlV+=",";}
				sqlC+=e.getKey();
				sqlV+=formatParameter(e.getValue().getClass(), e.getValue());
				colCount++;
			}
		}
		String sql=sqlC + ") "+ sqlV + ");";
		return sql;
	}

	private HashMap<String, Object> extractColumnsValues()
			throws IllegalAccessException, InvocationTargetException {

		HashMap<String,Object> CandV = new HashMap<String,Object>();
		for(Method f : this.getClass().getDeclaredMethods()){
			if(null!=f.getAnnotation(Column.class)){
				String c = ((Column)f.getAnnotation(Column.class)).name();
				Object v = f.invoke(this,(Object[])null);
				CandV.put(c, v);
			}
		}
		return CandV;
	}
	
	private static String update(String table){
		return "UPDATE "+table+" ";
	}
}
