package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.Contact;
import com.eethan.ineedu.databasebeans.Need;

public class ContactDAO extends DAO<Contact>{
	public static String TABLE_NAME = "contact";
	private static Class myClass = Contact.class;
	
	public static final String CID = "cid";
	public static final String USERID = "userId";
	public static final String CONTACTID = "contactId";
	public static final String CONTACTNAME = "contactName";
	public static final String TIME = "time";
	public static final String TYPE = "type";
	
	
	private Connection conn = null;
	
	public ContactDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	public List<Contact> getRecentContacts(int userId,int maxNum)
	{
	 	try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = "select * from "+getTableName()+" "
    				+"where userId = ? "
    				+"group by contactId order by Max(time) DESC "
    				+"limit 0,?"
    				;
    		
		PreparedStatement pstmt=conn.prepareStatement(sql); 
		pstmt.setObject(1, userId);
		pstmt.setObject(2, maxNum);
		pstmt.executeQuery();
		
		ResultSet rs=pstmt.executeQuery(); 
	     //遍历每条数据
	    List<Contact> list = new ArrayList<Contact>();
	    while (rs.next()) {
	    	Object obj = RSTravel(rs);
	    	list.add((Contact) obj);
	    }
		return list;
    	} catch (Exception e){
    		e.printStackTrace();
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
    		}
		return null;
	}
	public List<Contact> getGeneralContacts(int userId,int maxNum)
	{
	 	try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = "select * from "+getTableName()+" "
    				+"where userId = ? "
    				+"group by contactId order by COUNT(contactId) DESC "
    				+"limit 0,?"
    				;
    		
		PreparedStatement pstmt=conn.prepareStatement(sql); 
		pstmt.setObject(1, userId);
		pstmt.setObject(2, maxNum);
		pstmt.executeQuery(); 
		
		ResultSet rs=pstmt.executeQuery(); 
	     //遍历每条数据
	    List<Contact> list = new ArrayList<Contact>();
	    while (rs.next()) {
	    	Object obj = RSTravel(rs);
	    	list.add((Contact) obj);
	    }
		return list;
    	} catch (Exception e){
    		e.printStackTrace();
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
    		}
		return null;
	}
	
	public List<Contact> getContacts(int userid,int contactid){
		try {
			conn = DatabasePool.getInstance().getConnection();
			String sql = "select * from contact where userId =? and contactId=? order by time desc";
			PreparedStatement pstmt=conn.prepareStatement(sql); 
			pstmt.setObject(1, userid);
			pstmt.setObject(2, contactid);
			pstmt.executeQuery(); 
			ResultSet rs=pstmt.executeQuery(); 
		     //遍历每条数据
		    List<Contact> list = new ArrayList<Contact>();
		    while (rs.next()) {
		    	Object obj = RSTravel(rs);
		    	list.add((Contact) obj);
		    }
		    return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
    		}
		return null;
	}
	
	public void deleteARecord(int userid,int contactid){
		try {
			conn = DatabasePool.getInstance().getConnection();
			String sql = "delete from contact where userId =? and contactId=?";
			PreparedStatement pstmt=conn.prepareStatement(sql); 
			pstmt.setObject(1, userid);
			pstmt.setObject(2, contactid);
			pstmt.executeUpdate(); 
		} catch (Exception e) {
			
		}finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
    		}
	}
}

