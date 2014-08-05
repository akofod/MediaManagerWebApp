package edu.franklin.model;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import edu.franklin.dataaccess.BaseDAO;
import edu.franklin.dataaccess.BaseORM;


public class MediaManagerDAO extends BaseDAO {

    public MediaManagerDAO(String url, String userid, String password) {
      super(url, userid, password);
        getNumRecords();
    }
    
    public ArrayList<ItemView> getAllItems() {
    	ArrayList<ItemView> itemList = new ArrayList<ItemView>();
    	try {
            String sql = "SELECT * FROM mediamanager.item_view;";

            Statement s = getCon().createStatement();

            ResultSet rs = s.executeQuery(sql);
            System.out.println("SQL statement executed.");

            String name, genre, mediaType, comments;
            int year;

            while(rs.next())
            {
                name = rs.getString("Name");
                genre = rs.getString("GenreDescription");
                mediaType = rs.getString("MediaTypeDescription");
                comments = rs.getString("Comments");
                year = rs.getInt("Year");        
                
                ItemView item = new ItemView();
                item.setName(name);
                item.setGenre(genre);
                item.setMediaType(mediaType);
                item.setComments(comments);
                item.setYear(year);
                
                itemList.add(item);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return itemList;
    }
    
    public ArrayList<ItemDetail> searchItem(String searchName)
    {	
    	ArrayList<ItemDetail> itemList = new ArrayList<ItemDetail>();
        try {
            String sql = "SELECT * FROM mediamanager.item_view WHERE Name like '%"+searchName+"%'";

            Statement s = getCon().createStatement();

            ResultSet rs = s.executeQuery(sql);

            String name, genre, mediaType, comments, purLoc, purDate;
            int year;
            double curValue, purPrice;

            while(rs.next())
            {
            	name = rs.getString("Name");
                genre = rs.getString("GenreDescription");
                mediaType = rs.getString("MediaTypeDescription");
                year = rs.getInt("Year");
                comments = rs.getString("Comments");                
                curValue = rs.getDouble("CurrentValue");
                purLoc = rs.getString("PurchaseLocation");
                purDate = rs.getString("PurchaseDate");
                purPrice = rs.getDouble("PurchasePrice");
                purDate = purDate.substring(0, 10);
                
                ItemDetail item = new ItemDetail();
                item.setName(name);
                item.setGenre(genre);
                item.setMediaType(mediaType);
                item.setYear(year);
                item.setComments(comments);
                item.setCurVal(curValue);
                item.setPurLoc(purLoc);
                item.setPurDate(purDate);
                item.setPurPrice(purPrice);
                
                itemList.add(item);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return itemList;
    }
    
    public ArrayList<Genre> getGenres() {
    	ArrayList<Genre> genreList = new ArrayList<Genre>();
    	try {
            String sql = "SELECT mediamanager.genre.ID, mediamanager.genre.GenreDescription, count(mediamanager.mediaitem.GenreID) as itemCount from mediamanager.genre LEFT JOIN mediamanager.mediaitem on mediamanager.genre.ID = mediamanager.mediaitem.GenreID GROUP BY ID";

            Statement s = getCon().createStatement();

            ResultSet rs = s.executeQuery(sql);
            System.out.println("SQL statement executed.");
            
            int id, itemCount;
            String genreDesc;

            while(rs.next())
            {
                id = rs.getInt("ID");
                genreDesc = rs.getString("GenreDescription");
                itemCount = rs.getInt("itemCount");      
                
                Genre genre = new Genre();
                genre.setId(id);
                genre.setGenreDesc(genreDesc);
                genre.setItemCount(itemCount);
                
                genreList.add(genre);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return genreList;
    }
    
    public ArrayList<MediaType> getMediaTypes() {
    	ArrayList<MediaType> mediaTypeList = new ArrayList<MediaType>();
    	try {
            String sql = "SELECT mediamanager.mediatype.ID, mediamanager.mediatype.MediaTypeDescription, count(mediamanager.mediaitem.MediaTypeID) as itemCount from mediamanager.mediatype LEFT JOIN mediamanager.mediaitem on mediamanager.mediatype.ID = mediamanager.mediaitem.MediaTypeID GROUP BY ID";

            Statement s = getCon().createStatement();

            ResultSet rs = s.executeQuery(sql);
            System.out.println("SQL statement executed.");
            
            int id, itemCount;
            String typeDesc;

            while(rs.next())
            {
                id = rs.getInt("ID");
                typeDesc = rs.getString("MediaTypeDescription");
                itemCount = rs.getInt("itemCount");      
                
                MediaType type = new MediaType();
                type.setId(id);
                type.setMediaType(typeDesc);
                type.setItemCount(itemCount);
                
                mediaTypeList.add(type);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return mediaTypeList;
    }
    
    public ArrayList<PurchaseInfo> getPurchaseInfo() {
    	ArrayList<PurchaseInfo> info = new ArrayList<PurchaseInfo>();
    	try {
            String sql = "SELECT mediamanager.purchaseinfo.ID, mediamanager.purchaseinfo.PurchaseLocation, count(mediamanager.purchaseinfomediaitem.PurchaseInfoID) as itemCount from mediamanager.purchaseinfo LEFT JOIN mediamanager.purchaseinfomediaitem on mediamanager.purchaseinfo.ID = mediamanager.purchaseinfomediaitem.PurchaseInfoID GROUP BY ID";

            Statement s = getCon().createStatement();

            ResultSet rs = s.executeQuery(sql);
            
            int id, itemCount;
            String purLoc;
            
            while (rs.next()) {
            	id = rs.getInt("ID");
            	purLoc = rs.getString("PurchaseLocation");
            	itemCount = rs.getInt("itemCount");
            	
            	PurchaseInfo loc = new PurchaseInfo();
            	loc.setId(id);
            	loc.setPurLoc(purLoc);
            	loc.setItemCount(itemCount);
            	
            	info.add(loc);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    	return info;
    }
    
    public ArrayList<ItemDetail> getItemsByGenre(String genreName) {
    	ArrayList<ItemDetail> itemList = new ArrayList<ItemDetail>();
        try {
            String sql = "SELECT * FROM mediamanager.item_view WHERE GenreDescription like '%"+genreName+"%'";

            Statement s = getCon().createStatement();

            ResultSet rs = s.executeQuery(sql);

            String name, genre, mediaType, comments, purLoc, purDate;
            int year;
            double curValue, purPrice;

            while(rs.next())
            {
            	name = rs.getString("Name");
                genre = rs.getString("GenreDescription");
                mediaType = rs.getString("MediaTypeDescription");
                year = rs.getInt("Year");
                comments = rs.getString("Comments");                
                curValue = rs.getDouble("CurrentValue");
                purLoc = rs.getString("PurchaseLocation");
                purDate = rs.getString("PurchaseDate");
                purPrice = rs.getDouble("PurchasePrice");
                purDate = purDate.substring(0, 10);
                
                ItemDetail item = new ItemDetail();
                item.setName(name);
                item.setGenre(genre);
                item.setMediaType(mediaType);
                item.setYear(year);
                item.setComments(comments);
                item.setCurVal(curValue);
                item.setPurLoc(purLoc);
                item.setPurDate(purDate);
                item.setPurPrice(purPrice);
                
                itemList.add(item);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return itemList;
    }
    
    public ArrayList<ItemDetail> getItemsByType(String type) {
    	ArrayList<ItemDetail> itemList = new ArrayList<ItemDetail>();
        try {
            String sql = "SELECT * FROM mediamanager.item_view WHERE MediaTypeDescription like '%"+type+"%'";

            Statement s = getCon().createStatement();

            ResultSet rs = s.executeQuery(sql);

            String name, genre, mediaType, comments, purLoc, purDate;
            int year;
            double curValue, purPrice;

            while(rs.next())
            {
            	name = rs.getString("Name");
                genre = rs.getString("GenreDescription");
                mediaType = rs.getString("MediaTypeDescription");
                year = rs.getInt("Year");
                comments = rs.getString("Comments");                
                curValue = rs.getDouble("CurrentValue");
                purLoc = rs.getString("PurchaseLocation");
                purDate = rs.getString("PurchaseDate");
                purPrice = rs.getDouble("PurchasePrice");
                purDate = purDate.substring(0, 10);
                
                ItemDetail item = new ItemDetail();
                item.setName(name);
                item.setGenre(genre);
                item.setMediaType(mediaType);
                item.setYear(year);
                item.setComments(comments);
                item.setCurVal(curValue);
                item.setPurLoc(purLoc);
                item.setPurDate(purDate);
                item.setPurPrice(purPrice);
                
                itemList.add(item);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return itemList;
    }
    
    public ArrayList<ItemDetail> getItemsByLocation(String location) {
    	ArrayList<ItemDetail> itemList = new ArrayList<ItemDetail>();
        try {
            String sql = "SELECT * FROM mediamanager.item_view WHERE PurchaseLocation like '%"+location+"%'";

            Statement s = getCon().createStatement();

            ResultSet rs = s.executeQuery(sql);

            String name, genre, mediaType, comments, purLoc, purDate;
            int year;
            double curValue, purPrice;

            while(rs.next())
            {
            	name = rs.getString("Name");
                genre = rs.getString("GenreDescription");
                mediaType = rs.getString("MediaTypeDescription");
                year = rs.getInt("Year");
                comments = rs.getString("Comments");                
                curValue = rs.getDouble("CurrentValue");
                purLoc = rs.getString("PurchaseLocation");
                purDate = rs.getString("PurchaseDate");
                purPrice = rs.getDouble("PurchasePrice");
                purDate = purDate.substring(0, 10);
                
                ItemDetail item = new ItemDetail();
                item.setName(name);
                item.setGenre(genre);
                item.setMediaType(mediaType);
                item.setYear(year);
                item.setComments(comments);
                item.setCurVal(curValue);
                item.setPurLoc(purLoc);
                item.setPurDate(purDate);
                item.setPurPrice(purPrice);
                
                itemList.add(item);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return itemList;
    }
    
    public int getNumRecords() {
    	int num = 0;
    	try {
    		String sql = "SELECT * FROM mediamanager.mediaitem";
    		
    		Statement s = getCon().createStatement();

            ResultSet rs = s.executeQuery(sql);
            
            if (rs.next()) {
            	rs.last();
            	num = rs.getRow();
            }
    	}
    	catch(Exception e){
            System.out.println(e);
        }
    	return num;
    }
    
    public void close() {
    	try {
    		if (!getCon().isClosed()) {
    			getCon().close();
    		}
    	}
    	catch (Exception e) {
    		System.out.println(e);
    	}
    }

	private void doUpdate(BaseORM object) throws SQLException {
			String sql = "";
			try {
				sql = object.getUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				throw new SQLException("Error building Bean SQL, see stack trace.");
			} 
			Statement s = getCon().createStatement();
            s.executeUpdate(sql, Statement.NO_GENERATED_KEYS);			

	}

	private int doInsert(BaseORM object) throws SQLException {
		int id = 0;
		String sql = "";
		try {
			sql = object.getInsert();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Error building Bean SQL, see stack trace.");
		}
		Statement s = getCon().createStatement();
		id = s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		if (id > 0) {
			ResultSet rs = s.getGeneratedKeys();
			rs.next();
			id = rs.getInt(1);
		}
		return id;
	}

	public int addItem(BaseORM item) throws SQLException  {
		return doInsert(item);		
	}

	public void updateItem(BaseORM item) throws SQLException {
		this.doUpdate(item);
	}
	
	public void deleteItem(BaseORM item) throws SQLException{
		this.doDelete(item);
	}

	private void doDelete(BaseORM object) throws SQLException {
			String sql;
			try {
				sql = object.getDelete();
			} catch (Exception e) {
				e.printStackTrace();
				throw new SQLException("Error building Bean SQL, see stack trace.");
			} 
			Statement s = getCon().createStatement();
            s.executeUpdate(sql, Statement.NO_GENERATED_KEYS);			
	}

	public ArrayList<MediaItem> getMediaItems() throws SQLException, Exception {
		InputStream is = getClass().getResourceAsStream("mediaitems_fulljoin.sql");
		@SuppressWarnings("resource")
		String sql = new Scanner( is ).useDelimiter("\\A").next();
		is.close();
		ArrayList<MediaItem> miList = new ArrayList<MediaItem>();
		Statement s = getCon().createStatement();
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) {
			MediaItem mi = new MediaItem(rs);
			mi.setPurInfo(new PurchaseInfoMediaItem(rs));
			miList.add(mi);
		}
		return miList;
	}
}
