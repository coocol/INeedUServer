package com.eethan.ineedu.databasedao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eethan.ineedu.databasebeans.Plays;
import com.eethan.ineedu.util.ObjectToMap;

public class DAO<T> {
	public String TABLE_NAME;
	private Class myClass;
	private Connection conn = null;
	private boolean timeBug=false;
	
	
	public void save(Object obj){
    	try {
    		conn = DatabasePool.getInstance().getConnection();
    		Map<String, Object> map = ObjectToMap.toMap(obj);
    		map.remove(getPKName(conn));
    		
    		String sql="insert into "+getTableName()+" ( ";
    		for(String key : map.keySet())
    			sql+=key+",";
    		sql = (String) sql.subSequence(0,sql.length()-1);
    		sql+=") ";
    		
    		sql+="values ( ";
    		for(String key : map.keySet())
    		{
    			if(map.get(key) instanceof java.lang.String)
    				sql+="\""+map.get(key)+"\",";
    			else
    				sql+=map.get(key)+",";
    		}
    		sql = (String) sql.subSequence(0,sql.length()-1);
    		sql+=") ";
    		
		PreparedStatement pstmt=conn.prepareStatement(sql); 
		pstmt.executeUpdate(); 
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
	}
	public void update(Object obj){
    	try {
    		conn = DatabasePool.getInstance().getConnection();
    		Map<String, Object> map = ObjectToMap.toMap(obj);
//    		String sql="update "+TABLE_NAME+" set photoId=?,userId=?,commentedUserId=?,time=?,content=? where id=?"; 
    		String  sql="update "+getTableName()+" set ";
    		
    		String IdName = getPKName(conn);
    		int id = (Integer) map.get(IdName);
    		map.remove(IdName);
    		for(String key : map.keySet())
    		{
    			if(map.get(key) instanceof java.lang.String)
    				sql+=key+" = \""+map.get(key)+"\",";
    			else
    				sql+=key+" = "+map.get(key)+",";
    		}
    		sql = sql.substring(0, sql.length()-1);//去掉最后一个逗号
    		sql+=" where "+IdName+" ="+id;
    		PreparedStatement pstmt=conn.prepareStatement(sql); 
	    pstmt.executeUpdate(); 
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
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value){
	    	try {
	    		conn = DatabasePool.getInstance().getConnection();
	    		String sql="select * from "+getTableName()+" where "+propertyName + "=?";
	    		
			    PreparedStatement pstmt=conn.prepareStatement(sql); 
			    pstmt.setObject(1,value);
			    ResultSet rs=pstmt.executeQuery(); 
			     //遍历每条数据
			    List<T> list = new ArrayList<T>();
			    while (rs.next()) {
			    	Object obj = RSTravel(rs);
			    	list.add((T) obj);
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
	
	
	
	public List<T> getNearDatas(double lng,double lat,double distance,String sex,int start,int maxNum,boolean getMore){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null,sexSql = "";
    		PreparedStatement pstmt = null;
    		if(!sex.equals(""))
    			sexSql = " and sex = "+sex+" ";
    		if(getMore == true){
    			sql = "SELECT a.* FROM "+getTableName()+" AS a,userinfo AS b "
    					+ "where "
    					+"(6371.004*ACOS(SIN(?/180*PI())*SIN(a.lat/180*PI())+COS(?/180*PI())*COS(a.lat/180*PI())*COS((?-a.lng)/180*PI()))) "
						+"< ? "
    					+sexSql+"and a.id < ? and a.userId=b.userId Order BY a.id desc limit 0,?";

    		    pstmt=conn.prepareStatement(sql); 
    		    pstmt.setDouble(1, lat);
    		    pstmt.setDouble(2, lat);
    		    pstmt.setDouble(3, lng);
    		    pstmt.setDouble(4, distance/1000);
    		    pstmt.setInt(5, start);
    		    pstmt.setInt(6, maxNum);
    		    
    		}else{
    			sql = "SELECT a.* FROM "+getTableName()+" AS a,userinfo AS b "
    					+ "where (6371.004*ACOS(SIN(?/180*PI())*SIN(lat/180*PI())+COS(?/180*PI())*COS(lat/180*PI())*COS((?-lng)/180*PI()))) "
						+"< ? "+"and a.userId=b.userId Order BY a.id desc limit 0,?";

    			pstmt=conn.prepareStatement(sql); 
    		    pstmt.setDouble(1, lat);
    		    pstmt.setDouble(2, lat);
    		    pstmt.setDouble(3, lng);
    		    pstmt.setDouble(4, distance/1000);
    		    pstmt.setInt(5, maxNum);
    		}
    		
		    ResultSet rs=pstmt.executeQuery(); 
		     //遍历每条数据
		    List<T> list = new ArrayList<T>();
		    
		    while (rs.next()) {
		    Object object = RSTravel(rs);
		    	list.add((T) object);
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
	//遍历ResultSet
	public Object RSTravel(ResultSet rs) 
	{
		Field field = null;
		Object obj = null;
		Class clazz = getMyClass();
			try {
				obj = clazz.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Map<String, Object> map = null;
				map = ObjectToMap.toMap(obj);
	    	for(String key : map.keySet())
	    	{
			try {
				field = clazz.getDeclaredField(key);
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(timeBug)
	    			{
					if(key.equals("time")||key.equals("timeLimit"))
						
							field.set(obj,Long.parseLong((String)rs.getObject(key)));
						
					else
			    			field.set(obj, rs.getObject(key));
				}else{
		    			try {
							field = clazz.getDeclaredField(key);
						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		field.set(obj, rs.getObject(key));
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	    		
	    	}
	    	return obj;
	}
	
	
	private String getPKName(Connection conn){ 
	    String idName = "";  
	    String tableName = getTableName();
	    DatabaseMetaData  metaData = null;  
	    try {  
	         metaData = conn.getMetaData();  
	         ResultSet rs = metaData.getColumns(conn.getCatalog(), "%", tableName, "%ID");  
	         if(rs.next()){  
	             idName = rs.getString("COLUMN_NAME");   
	         }  
	    } catch (Exception e) {  
	        System.out.println("Find PK Error!"); 
	    }  
	    System.out.println("PK Name:"+idName);
	    return idName;  
	}  
	@SuppressWarnings("unchecked")
	public <T> List<T> exeRawQuery(String where) throws SQLException, InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException, IllegalArgumentException
	{
		conn = DatabasePool.getInstance().getConnection();
		PreparedStatement pstmt=conn.prepareStatement("select * from "+getTableName()+" "+where); 
		ResultSet rs=pstmt.executeQuery(); 
		
		List<T> list = new ArrayList<T>();
		 while (rs.next()) {
			    Object object = RSTravel(rs);
			    	list.add((T) object);
			    }
		return list;
	}
	
	protected void setTableName(String tableName)
	{
		TABLE_NAME = tableName;
	}
	protected String getTableName()
	{
		return TABLE_NAME;
	}
	protected void setClass(Class c)
	{
		myClass = c;
	}
	protected Class getMyClass()
	{
		return myClass;
	}
	public boolean isTimeBug() {
		return timeBug;
	}
	public void setTimeBug(boolean timeBug) {
		this.timeBug = timeBug;
	}
	
}
