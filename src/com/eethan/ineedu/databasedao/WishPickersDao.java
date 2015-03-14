package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.WishPicker;

public class WishPickersDao extends DAO<WishPicker>{

	public static final String TABLE_NAME = "wishpickers";
	private static Class myClass = WishPicker.class;
	
	private Connection conn;
	
	public static final String ID="id";
	public static final String WISHID="wishId";
	public static final String USERID="userId";
	public static final String OWNERID="ownerId";
	
	public WishPickersDao(){
		setClass(myClass);
		setTableName(TABLE_NAME);
	}
	
	
	public boolean isExist(int userId ,int wishId )
	{
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = "select * from "+getTableName()+" "
    				+"where userId = ? and wishId = ?"
    				;
    		
		PreparedStatement pstmt=conn.prepareStatement(sql); 
		pstmt.setObject(1, userId);
		pstmt.setObject(2, wishId);
		pstmt.executeQuery(); 
		
		ResultSet rs=pstmt.executeQuery(); 
	     //遍历每条数据
	    List<WishPicker> list = new ArrayList<WishPicker>();
	    while (rs.next()) {
	    	Object obj = RSTravel(rs);
	    	list.add((WishPicker) obj);
	    }
	    if(list.size() == 0)
	    		return false;
		return true;
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
		return false;
	
	}
	
	public int getPickerCount(int wishId)
	{
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = "select count(*) as num from "+getTableName()+" "
    				+"where wishId = ?"
    				;
    		
		PreparedStatement pstmt=conn.prepareStatement(sql); 
		pstmt.setObject(1, wishId);
		pstmt.executeQuery(); 
		
		ResultSet rs=pstmt.executeQuery(); 
	     //遍历每条数据
	    int nn = 0;
	    while (rs.next()) {
	    	nn = rs.getInt("num");
	    }
	    return nn;
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
		return 0;
	
	}
}
