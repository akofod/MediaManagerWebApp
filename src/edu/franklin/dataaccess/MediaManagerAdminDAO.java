package edu.franklin.dataaccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.franklin.model.UserDetail;


public class MediaManagerAdminDAO extends BaseDAO {
	
	public MediaManagerAdminDAO(String url, String userid, String password) {
		super(url, userid, password);
	}

	public UserDetail authenticateUser(String userId, String password){
		UserDetail ud = null;
		try {
            String sql = "SELECT * FROM userdetails where USERNAME=? AND PASSWORD=?";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
            	ud = new UserDetail(rs);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
		return ud;
	}

}
