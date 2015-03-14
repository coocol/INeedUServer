package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.User;

public class UserDAO extends DAO<User>{
	public static String TABLE_NAME = "user";
	private static Class myClass = User.class;
	
	public static final String ID = "id";
	public static final String TELE = "tele";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String UID = "uid";
	public static final String IMAGEURL = "imageUrl";
	
	private Connection conn = null;
	
	public UserDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	
	public int deleteEmptyUser(User user){
    	try {
    		conn = DatabasePool.getInstance().getConnection();
    		int userId = user.getId();
    		String sql="delete from userlocation where userId=?"; 
		    PreparedStatement pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,userId); 
		    pstmt.executeUpdate(); 
		    
		    
		    sql="delete from lovepopularityincrease where userId=?"; 
		    pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,userId); 
		    pstmt.executeUpdate(); 
		    
		    sql="delete from userinfo where userId=?"; 
		    pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,userId); 
		    pstmt.executeUpdate(); 
		    
		    sql="delete from userdetailinfo where userId=?"; 
		    pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,userId); 
		    pstmt.executeUpdate(); 
		    
		    sql="delete from user where id=?"; 
		    pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,userId); 
		    return pstmt.executeUpdate(); 
		    
		   
    	} catch (Exception e){
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
    	return 0;
	}
	
	
	
	
	
}
