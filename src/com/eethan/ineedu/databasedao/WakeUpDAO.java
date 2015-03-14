package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.WakeUp;

public class WakeUpDAO extends DAO<WakeUp>{
	public static String TABLE_NAME = "wakeup";
	private static Class myClass = WakeUp.class;
	
	public static final String WAID = "waid";
	public static final String USERID = "userId";
	public static final String SEX = "sex";
	public static final String AUTH = "auth";
	public static final String AQUIREMENT = "aquirement";
	public static final String SCOPE = "scope";
	public static final String DATE = "date";
	public static final String PRAISEUSERID = "praiseUserId";
	
	public static final String BOY = "男";
	public static final String GIRL = "女";
	
	private Connection conn = null;
	
	public WakeUpDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	public List<WakeUp> match(double lng,double lat,double distance,String sex,int userId){
	 	try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql="select * from "+getTableName()+" as a,userinfo as b,userlocation as c where "
    				+ "(6371.004*ACOS(SIN("+lat+"/180*PI())*SIN(c.lat/180*PI())+COS("+lat+"/180*PI())*COS(c.lat/180*PI())*COS(("+lng+"-c.lng)/180*PI()))) "
    				+ "< "+distance/1000+" and a.userId = b.userId and b.userId = c.userId  and a.pairUserId = 0 and a.userId <>"+userId+" and b.sex = '"+sex+"'";
    			System.out.println(sql);
		    PreparedStatement pstmt=conn.prepareStatement(sql); 
//		    pstmt.setObject(1,lat);
//		    pstmt.setObject(2,lat);
//		    pstmt.setObject(3,lng);
//		    pstmt.setObject(4,distance/1000);
//		    pstmt.setObject(5,sex);
		    ResultSet rs=pstmt.executeQuery(); 
		     //遍历每条数据
		    List<WakeUp> list = new ArrayList<WakeUp>();
		    while (rs.next()) {
		    	Object obj = RSTravel(rs);
		    	list.add((WakeUp) obj);
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
	public int count()
	{
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql="select count(*) from "+getTableName();
    		
		    PreparedStatement pstmt=conn.prepareStatement(sql); 
		    
		   
		    ResultSet rs=pstmt.executeQuery(); 
		   
		    int num = 0;
		    while (rs.next()) {
		    		num = rs.getInt("count(*)");
		    }
		
    		return num;
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
	public int count(String sex)
	{
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String date = new Date(new java.util.Date().getTime()).toString();
    		String sql="select count(*) from "+getTableName()+" where sex = '"+sex+"' and date = '"+date+"'";
    		
		    PreparedStatement pstmt=conn.prepareStatement(sql); 
		    ResultSet rs=pstmt.executeQuery(); 
		   
		    int num = 0;
		    while (rs.next()) {
		    		num = rs.getInt("count(*)");
		    }
		
    		return num;
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
