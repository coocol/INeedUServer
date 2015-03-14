package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.Need;

public class NeedDAO extends DAO<Need>{
	public static String TABLE_NAME = "need";
	private static Class myClass = Need.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String CONTENT = "content";
	public static final String TIME = "time";
	public static final String LNG = "lng";
	public static final String LAT = "lat";
	public static final String REWARD = "reward";
	public static final String TYPE = "type";
	public static final String REPORTNUM = "reportNum";
	public static final String COMMENTNUM = "commentNum";	
	public static final String SOLVEID = "solveId";	
	
	public static final int ASC=0;//默认升序
	public static final int DESC=1;//降序
	
	private Connection conn = null;
	
	public NeedDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
		setTimeBug(true);
	}
	
	public int delete(Need need){
    	try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql="delete from needcomment where needId=?"; 
		    PreparedStatement pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,need.getId()); 
		    pstmt.executeUpdate(); 
		    
		    String sql2="delete from notification where notificationId=? and noticeFlag=1 or noticeFlag=-1"; 
		    PreparedStatement pstmt2=conn.prepareStatement(sql2); 
		    pstmt2.setInt(1,need.getId()); 
		    pstmt2.executeUpdate(); 
		    
		    String sql3="delete from need where id=?";
		    PreparedStatement pstmt3=conn.prepareStatement(sql3); 
		    pstmt3.setInt(1,need.getId()); 
		    return pstmt3.executeUpdate(); 
		   
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
	
	
	//重载
	public List<Need> getAllNeeds(int userId,int lastNum,int maxNum,boolean getMore){
    	try {
    		conn = DatabasePool.getInstance().getConnection();
    		ResultSet rs;
    		
    		if(getMore)
    		{
    			String sql="select * from need "
    				+ "where userId =?"
    				+ " and id< ?"
    				+ " order by id desc"
    				+ " limit 0,?"; 
			    PreparedStatement pstmt=conn.prepareStatement(sql); 
			    pstmt.setObject(1,userId);
			    pstmt.setObject(2,lastNum);
			    pstmt.setObject(3,maxNum);
			    rs=pstmt.executeQuery(); 
    		}
    		else {
    			String sql="select * from need "
        				+ "where userId=?"
        				+ " order by id desc"
        				+ " limit 0,?"; 
    			    PreparedStatement pstmt=conn.prepareStatement(sql); 
    			    pstmt.setObject(1,userId);
    			    pstmt.setObject(2,maxNum);
    			    rs=pstmt.executeQuery(); 
			}
		     //遍历每条数据
		    List<Need> list = new ArrayList<Need>();
		    while (rs.next()) {
		    	Need need = new Need();
		    	need.setId(rs.getInt("id")); 
		    	need.setUserId(rs.getInt("userId"));
		    	need.setContent(rs.getString("content"));
		    	need.setTime(rs.getLong("time"));
		    	need.setLng(rs.getDouble("lng")); 
		    	need.setLat(rs.getDouble("lat")); 
		    	need.setTimeLimit(rs.getLong("timeLimit"));
		    	need.setReward(rs.getString("reward"));
		    	need.setType(rs.getInt("type")); 
		    	need.setReportNum(rs.getInt("reportNum")); 
		    	need.setCommentNum(rs.getInt("commentNum"));
		    	need.setSolveId(rs.getInt("solveId"));
		    	list.add(need);
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
	/**
	 * 得到附近的需求
	 * @param mylng 请求者的经度
	 * @param myLat 请求者的纬度
	 * @param type 需求类型
	 * @param sex 需求性别
	 * @param distance 范围
	 * @param start 上次加载到的最早的需求的id
	 * @param maxNum 返回条数
	 * @param getMore 是getMore还是refresh
	 * @return 
	 */
	public List<Need> getNearNeed(double myLng,double myLat,int type,String sex,double distance,int start,int maxNum,boolean getMore){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null;
    		PreparedStatement pstmt = null;
    		
    		String typeSql = "";
    		String sexSql = "";
    		
    		if(type != -1)
    			typeSql = "and type="+type+" ";
    		if(!sex.equals("")) 
    			sexSql = "and sex="+"'"+sex+"' ";
    		
    		
    		if(getMore == true){
    			sql = "SELECT a.* FROM need AS a,userinfo AS b "
    					+ "where "
    					+"(6371.004*ACOS(SIN(?/180*PI())*SIN(a.lat/180*PI())+COS(?/180*PI())*COS(a.lat/180*PI())*COS((?-a.lng)/180*PI()))) "
						+"< ? "
    					+typeSql+sexSql+"and a.id < ? and a.userId=b.userId Order BY a.id desc limit 0,?";

    		    pstmt=conn.prepareStatement(sql); 
    		    pstmt.setDouble(1, myLat);
    		    pstmt.setDouble(2, myLat);
    		    pstmt.setDouble(3, myLng);
    		    pstmt.setDouble(4, distance/1000);
    		    pstmt.setInt(5, start);
    		    pstmt.setInt(6, maxNum);
    		    
    		}else{
    			sql = "SELECT a.* FROM need AS a,userinfo AS b "
    					+ "where (6371.004*ACOS(SIN(?/180*PI())*SIN(lat/180*PI())+COS(?/180*PI())*COS(lat/180*PI())*COS((?-lng)/180*PI()))) "
						+"< ? "+typeSql+sexSql+"and a.userId=b.userId Order BY a.id desc limit 0,?";

    			pstmt=conn.prepareStatement(sql); 
    		    pstmt.setDouble(1, myLat);
    		    pstmt.setDouble(2, myLat);
    		    pstmt.setDouble(3, myLng);
    		    pstmt.setDouble(4, distance/1000);
    		    pstmt.setInt(5, maxNum);
    		}
    		
		    ResultSet rs=pstmt.executeQuery(); 
		     //遍历每条数据
		    List<Need> list = new ArrayList<Need>();
		    while (rs.next()) {
		    	Need need = new Need();
		    	need.setId(rs.getInt("id")); 
		    	need.setUserId(rs.getInt("userId"));
		    	need.setContent(rs.getString("content"));
		    	need.setTime(rs.getLong("time"));
		    	need.setLng(rs.getDouble("lng")); 
		    	need.setLat(rs.getDouble("lat")); 
		    	need.setTimeLimit(rs.getLong("timeLimit"));
		    	need.setReward(rs.getString("reward"));
		    	need.setType(rs.getInt("type")); 
		    	need.setReportNum(rs.getInt("reportNum")); 
		    	need.setCommentNum(rs.getInt("commentNum"));
		    	need.setSolveId(rs.getInt("solveId"));
		    	list.add(need);
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
    	return new ArrayList<Need>();
	}
	
	
}

