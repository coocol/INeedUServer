package com.eethan.ineedu.databasedao;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.TakePhotos;
import com.eethan.ineedu.util.ObjectToMap;

public class TakePhotosDAO extends DAO<TakePhotos>{
	public static String TABLE_NAME = "takephotos";
	private static Class myClass = TakePhotos.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String CONTENT = "content";
	public static final String TIME = "time";
	public static final String LNG = "lng";
	public static final String LAT = "lat";
	public static final String PRAISENUM = "praiseNum";
	public static final String TRANSMITNUM = "transmitNum";
	public static final String TRANSMITFROM = "transmitFrom";
	public static final String TRANSMITID = "transmitId";
	public static final String COMMENTNUM = "commentNum";
	public static final String IMAGEURL = "imageUrl";
	
	private Connection conn = null;
	
	public TakePhotosDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	
	public List<TakePhotos> getNearPhotos(double myLng,double myLat,String sex,double distance,int start,int maxNum,boolean getMore){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null;
    		PreparedStatement pstmt = null;
    		
    		String sexSql = "";
    		
    		
    		if(!sex.equals("")) 
    			sexSql = "and sex="+"'"+sex+"' ";
    		
    		
    		if(getMore == true){
    			sql = "SELECT a.* FROM "+getTableName()+" AS a,userinfo AS b "
    					+ "where "
    					+"(6371.004*ACOS(SIN(?/180*PI())*SIN(a.lat/180*PI())+COS(?/180*PI())*COS(a.lat/180*PI())*COS((?-a.lng)/180*PI()))) "
						+"< ? "
    					+sexSql+"and a.id < ? and a.userId=b.userId Order BY a.id desc limit 0,?";

    		    pstmt=conn.prepareStatement(sql); 
    		    pstmt.setDouble(1, myLat);
    		    pstmt.setDouble(2, myLat);
    		    pstmt.setDouble(3, myLng);
    		    pstmt.setDouble(4, distance/1000);
    		    pstmt.setInt(5, start);
    		    pstmt.setInt(6, maxNum);
    		    
    		}else{
    			sql = "SELECT a.* FROM "+getTableName()+" AS a,userinfo AS b "
    					+ "where (6371.004*ACOS(SIN(?/180*PI())*SIN(lat/180*PI())+COS(?/180*PI())*COS(lat/180*PI())*COS((?-lng)/180*PI()))) "
						+"< ? "+sexSql+"and a.userId=b.userId Order BY a.id desc limit 0,?";

    			pstmt=conn.prepareStatement(sql); 
    		    pstmt.setDouble(1, myLat);
    		    pstmt.setDouble(2, myLat);
    		    pstmt.setDouble(3, myLng);
    		    pstmt.setDouble(4, distance/1000);
    		    pstmt.setInt(5, maxNum);
    		}
    		
		    ResultSet rs=pstmt.executeQuery(); 
		     //遍历每条数据
		    List<TakePhotos> list = new ArrayList<TakePhotos>();
		    
		    Field field;
		    while (rs.next()) {
		    	TakePhotos obj = new TakePhotos();
		    	Map<String, Object> map = ObjectToMap.toMap(obj);
		    	for(String key : map.keySet())
		    	{
		    		field = TakePhotos.class.getDeclaredField(key);
		    		field.set(obj, rs.getObject(key));
		    	}
		    	
		    	list.add(obj);
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
			}
    	}
    	return new ArrayList<TakePhotos>();
	}
	
	
}

