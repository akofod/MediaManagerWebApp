package edu.franklin.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO {
	protected String userid;
	protected String password;
    protected String url;
	protected Connection con = null;

	protected BaseDAO(String url, String userid, String password) {
		  this.url = url;
	        this.userid = userid;
	        this.password = password;
	}
	
	protected void createConnection(String url, String userid, String password){

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, userid, password);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
	
	protected Connection getCon() {
		/* since this DAO object is going into the context 
		 * of every servlet, lets delay the creation of a 
		 * connection until this instance actually calls for one */
		if(null == con)
			createConnection(url, userid, password);
		return con;
	}

}
