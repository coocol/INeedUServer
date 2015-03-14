package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.PourListenNoSex;
import com.eethan.ineedu.databasebeans.Pourlisten;

public class PourlistenDAO extends DAO<PourListenNoSex> {
	public static String TABLE_NAME = "pourlisten";
	private static Class myClass = PourListenNoSex.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String CONTENT = "content";
	public static final String TIME = "time";
	public static final String LNG = "lng";
	public static final String LAT = "lat";
	public static final String COMMENTNUM = "commentNum";	
	public static final String IMAGEURL = "imageUrl";	
	
	private Connection conn = null;
	
	public PourlistenDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
		setTimeBug(true);
	}
	
	public int delete(int pourlistenId){
    	try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql="delete from pourlisten where id=?"; 
		    PreparedStatement pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,pourlistenId); 
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
	
	/**
	 * 获取附近的倾诉倾听
	 * @return
	 */
	public List<PourListenNoSex> getNearPourlisten(int start,boolean getMore){
    	try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql;
			PreparedStatement pstmt;
    		if (!getMore) {
	    		sql = "select * from pourlisten order by id desc limit 0,?"; 
	    		pstmt = conn.prepareStatement(sql); 
			    pstmt.setInt(1,10);
			}else {
	    		sql = "select * from pourlisten where id<? order by id desc limit 0,?"; 
	    		pstmt = conn.prepareStatement(sql); 
			    pstmt.setInt(1,start);
			    pstmt.setInt(2,10);
			}
			    
		    ResultSet rs=pstmt.executeQuery(); 
		     //遍历每条数据
		    List<PourListenNoSex> list = new ArrayList<PourListenNoSex>();
		    while (rs.next()) {
		    	PourListenNoSex pourlisten = new PourListenNoSex();
		    	pourlisten.setId(rs.getInt("id")); 
		    	pourlisten.setUserId(rs.getInt("userId"));
		    	pourlisten.setContent(rs.getString("content"));
		    	pourlisten.setTime(rs.getLong("time"));
		    	pourlisten.setLng(rs.getDouble("lng")); 
		    	pourlisten.setLat(rs.getDouble("lat")); 
		    	pourlisten.setCommentNum(rs.getInt("commentNum"));
		    	pourlisten.setImageUrl(rs.getString("imageUrl"));
		    	list.add(pourlisten);
		    }
    		return list;
    	} catch (Exception e){
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
    	return null;
	}
}
