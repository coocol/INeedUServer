package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eethan.ineedu.databasebeans.LovePopularityIncrease;
import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;
import com.eethan.ineedu.util.ChineseInitial;

public class UserInfoDAO extends DAO<UserInfo>{
	public static String TABLE_NAME = "userinfo";
	private static Class myClass = UserInfo.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String NICKNAME = "nickName";
	public static final String REALNAME = "realName";
	public static final String SEX = "sex";
	public static final String LOVENUM = "loveNum";
	public static final String POPULARITYNUM = "popularityNum";
	public static final String FLAG = "flag";
	
	private Connection conn = null;
	
	public UserInfoDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	
	/**
	 * 获取爱心榜
	 * @param myLng 
	 * @param myLat
	 * @param distance 
	 * @param userInfos 
	 * @param userLocations
	 */
	public void getLoveRank(double myLng,double myLat,double distance,List<UserInfo> userInfos,List<UserLocation> userLocations){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null;
    		PreparedStatement pstmt = null;
			sql = "SELECT a.*,b.lng,b.lat FROM userinfo AS a,userlocation AS b "
					+ "where (6371.004*ACOS(SIN(?/180*PI())*SIN(b.lat/180*PI())+COS(?/180*PI())*COS(b.lat/180*PI())*COS((?-b.lng)/180*PI()))) "
					+"< ? and a.userId=b.userId Order BY a.loveNum desc limit 0,50";

		    pstmt=conn.prepareStatement(sql); 
		    pstmt.setDouble(1, myLat);
		    pstmt.setDouble(2, myLat);
		    pstmt.setDouble(3, myLng);
		    pstmt.setDouble(4, distance/1000);
		
		    ResultSet rs=pstmt.executeQuery(); 
		    
		    //遍历每条数据
		    while (rs.next()) {
			    UserInfo userInfo = new UserInfo();
		    	userInfo.setId(rs.getInt("id"));
		    	userInfo.setUserId(rs.getInt("userId"));
		    	userInfo.setNickName(rs.getString("nickName"));
		    	userInfo.setRealName(rs.getString("realName"));
		    	userInfo.setSex(rs.getString("sex"));
		    	userInfo.setLoveNum(rs.getInt("loveNum"));
		    	userInfo.setPopularityNum(rs.getInt("popularityNum"));
		    	userInfos.add(userInfo);
		    	
		    	UserLocation userLocation = new UserLocation();
		    	userLocation.setLng(rs.getDouble("lng"));
		    	userLocation.setLat(rs.getDouble("lat"));
		    	userLocations.add(userLocation);
		    }
    	} catch (Exception e){
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
	}

	/**
	 * 获取爱心增长榜
	 * @param myLng
	 * @param myLat
	 * @param distance
	 * @param icreaseUserInfos
	 * @param icreaseuserLocations
	 * @param lovePopularityIncreases
	 */
	public void getLoveIncreaseRank(double myLng,double myLat,double distance,
			List<UserInfo> increaseUserInfos,List<UserLocation> increaseuserLocations,List<LovePopularityIncrease> lovePopularityIncreases){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null;
    		PreparedStatement pstmt = null;
			sql = "SELECT a.*,b.lng,b.lat,c.increaseloveNum FROM userinfo AS a,userlocation AS b,lovepopularityincrease AS c "
					+ "where (6371.004*ACOS(SIN(?/180*PI())*SIN(b.lat/180*PI())+COS(?/180*PI())*COS(b.lat/180*PI())*COS((?-b.lng)/180*PI()))) "
					+"< ? and a.userId=b.userId and a.userId=c.userId Order BY c.increaseloveNum desc limit 0,50";

		    pstmt=conn.prepareStatement(sql); 
		    pstmt.setDouble(1, myLat);
		    pstmt.setDouble(2, myLat);
		    pstmt.setDouble(3, myLng);
		    pstmt.setDouble(4, distance/1000);
		
		    ResultSet rs=pstmt.executeQuery(); 
		    
		    //遍历每条数据
		    while (rs.next()) {
			    UserInfo userInfo = new UserInfo();
		    	userInfo.setId(rs.getInt("id"));
		    	userInfo.setUserId(rs.getInt("userId"));
		    	userInfo.setNickName(rs.getString("nickName"));
		    	userInfo.setRealName(rs.getString("realName"));
		    	userInfo.setSex(rs.getString("sex"));
		    	userInfo.setLoveNum(rs.getInt("loveNum"));
		    	userInfo.setPopularityNum(rs.getInt("popularityNum"));
		    	increaseUserInfos.add(userInfo);
		    	
		    	UserLocation userLocation = new UserLocation();
		    	userLocation.setLng(rs.getDouble("lng"));
		    	userLocation.setLat(rs.getDouble("lat"));
		    	increaseuserLocations.add(userLocation);
		    	
		    	LovePopularityIncrease lovePopularityIncrease = new LovePopularityIncrease();
		    	lovePopularityIncrease.setIncreaseLoveNum(rs.getInt("increaseLoveNum"));
		    	lovePopularityIncreases.add(lovePopularityIncrease);
		    }
    	} catch (Exception e){
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
	}
	
	/**
	 * 获取人气榜
	 * @param myLng 
	 * @param myLat
	 * @param distance 
	 * @param userInfos 
	 * @param userLocations
	 */
	public void getPopularityRank(double myLng,double myLat,double distance,List<UserInfo> userInfos,List<UserLocation> userLocations){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null;
    		PreparedStatement pstmt = null;
			sql = "SELECT a.*,b.lng,b.lat FROM userinfo AS a,userlocation AS b "
					+ "where (6371.004*ACOS(SIN(?/180*PI())*SIN(b.lat/180*PI())+COS(?/180*PI())*COS(b.lat/180*PI())*COS((?-b.lng)/180*PI()))) "
					+"< ? and a.userId=b.userId Order BY a.popularityNum desc limit 0,50";

		    pstmt=conn.prepareStatement(sql); 
		    pstmt.setDouble(1, myLat);
		    pstmt.setDouble(2, myLat);
		    pstmt.setDouble(3, myLng);
		    pstmt.setDouble(4, distance/1000);
		
		    ResultSet rs=pstmt.executeQuery(); 
		    
		    //遍历每条数据
		    while (rs.next()) {
			    UserInfo userInfo = new UserInfo();
		    	userInfo.setId(rs.getInt("id"));
		    	userInfo.setUserId(rs.getInt("userId"));
		    	userInfo.setNickName(rs.getString("nickName"));
		    	userInfo.setRealName(rs.getString("realName"));
		    	userInfo.setSex(rs.getString("sex"));
		    	userInfo.setLoveNum(rs.getInt("loveNum"));
		    	userInfo.setPopularityNum(rs.getInt("popularityNum"));
		    	userInfos.add(userInfo);
		    	
		    	UserLocation userLocation = new UserLocation();
		    	userLocation.setLng(rs.getDouble("lng"));
		    	userLocation.setLat(rs.getDouble("lat"));
		    	userLocations.add(userLocation);
		    }
    	} catch (Exception e){
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
	}
	
	/**
	 * 获取人气增长榜
	 * @param myLng
	 * @param myLat
	 * @param distance
	 * @param icreaseUserInfos
	 * @param icreaseuserLocations
	 * @param lovePopularityIncreases
	 */
	public void getPopularityIncreaseRank(double myLng,double myLat,double distance,
			List<UserInfo> increaseUserInfos,List<UserLocation> increaseuserLocations,List<LovePopularityIncrease> lovePopularityIncreases){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null;
    		PreparedStatement pstmt = null;
			sql = "SELECT a.*,b.lng,b.lat,c.increasePopularityNum FROM userinfo AS a,userlocation AS b,lovepopularityincrease AS c "
					+ "where (6371.004*ACOS(SIN(?/180*PI())*SIN(b.lat/180*PI())+COS(?/180*PI())*COS(b.lat/180*PI())*COS((?-b.lng)/180*PI()))) "
					+"< ? and a.userId=b.userId and a.userId=c.userId Order BY c.increasePopularityNum desc limit 0,50";

		    pstmt=conn.prepareStatement(sql); 
		    pstmt.setDouble(1, myLat);
		    pstmt.setDouble(2, myLat);
		    pstmt.setDouble(3, myLng);
		    pstmt.setDouble(4, distance/1000);
		
		    ResultSet rs=pstmt.executeQuery(); 
		    
		    //遍历每条数据
		    while (rs.next()) {
			    UserInfo userInfo = new UserInfo();
		    	userInfo.setId(rs.getInt("id"));
		    	userInfo.setUserId(rs.getInt("userId"));
		    	userInfo.setNickName(rs.getString("nickName"));
		    	userInfo.setRealName(rs.getString("realName"));
		    	userInfo.setSex(rs.getString("sex"));
		    	userInfo.setLoveNum(rs.getInt("loveNum"));
		    	userInfo.setPopularityNum(rs.getInt("popularityNum"));
		    	increaseUserInfos.add(userInfo);
		    	
		    	UserLocation userLocation = new UserLocation();
		    	userLocation.setLng(rs.getDouble("lng"));
		    	userLocation.setLat(rs.getDouble("lat"));
		    	increaseuserLocations.add(userLocation);
		    	
		    	LovePopularityIncrease lovePopularityIncrease = new LovePopularityIncrease();
		    	lovePopularityIncrease.setIncreasePopularityNum(rs.getInt("increasePopularityNum"));
		    	lovePopularityIncreases.add(lovePopularityIncrease);
		    }
    	} catch (Exception e){
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
	}
	
	/**
	 * 获取附近的人
	 * @param myLng
	 * @param myLat
	 * @param userInfos
	 * @param userLocations
	 */
	public int getNearUser(double myLng,double myLat,int myUserId,int start,String sex,double distance,
			List<UserInfo> userInfos,List<UserLocation> userLocations){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null;
    		PreparedStatement pstmt = null;
    		
    		String sexSql = "";
    		
    		long nowtime = new Date().getTime();
    		long timegap = 7*24*60*60*1000;
    		long timeline = nowtime-timegap;

    		if(!sex.equals("")) 
    			sexSql = "a.sex="+"'"+sex+"' and ";
    		
			sql = "SELECT a.*,b.id as lid,b.userId as luserId,b.time,b.lng,b.lat,"
					+ "(6371.004*ACOS(SIN(?/180*PI())*SIN(b.lat/180*PI())+COS(?/180*PI())*COS(b.lat/180*PI())*COS((?-b.lng)/180*PI()))) As juli "
					+ "FROM userinfo AS a,userlocation AS b "
					+ "where "
					+ "(6371.004*ACOS(SIN(?/180*PI())*SIN(b.lat/180*PI())+COS(?/180*PI())*COS(b.lat/180*PI())*COS((?-b.lng)/180*PI())))< ? and "
					+ sexSql
					+ " a.userId<> ? and a.userId=b.userId and b.time>? Order BY juli asc limit ?,30";
			pstmt=conn.prepareStatement(sql); 
		    pstmt.setDouble(1, myLat);
		    pstmt.setDouble(2, myLat);
		    pstmt.setDouble(3, myLng);
		    pstmt.setDouble(4, myLat);
		    pstmt.setDouble(5, myLat);
		    pstmt.setDouble(6, myLng);
		    pstmt.setDouble(7, distance/1000);
		    pstmt.setInt(8, myUserId);
		    pstmt.setString(9, String.valueOf(timeline));
		    pstmt.setInt(10, start);
		    ResultSet rs=pstmt.executeQuery(); 
		   
		    //遍历每条数据
		    while (rs.next()) {
			    UserInfo userInfo = new UserInfo();
		    	userInfo.setId(rs.getInt("id"));
		    	userInfo.setUserId(rs.getInt("userId"));
		    	userInfo.setNickName(rs.getString("nickName"));
		    	userInfo.setRealName(rs.getString("realName"));
		    	userInfo.setSex(rs.getString("sex"));
		    	userInfo.setLoveNum(rs.getInt("loveNum"));
		    	userInfo.setPopularityNum(rs.getInt("popularityNum"));
		    	userInfos.add(userInfo);
		    	
		    	UserLocation userLocation = new UserLocation();
		    	userLocation.setId(rs.getInt("lid"));
		    	userLocation.setUserId(rs.getInt("luserId"));
		    	userLocation.setLng(rs.getDouble("lng"));
		    	userLocation.setLat(rs.getDouble("lat"));
		    	userLocation.setTime(rs.getLong("time"));
		    	userLocations.add(userLocation);
		    }
		    return start+userInfos.size();
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
	
	public int getNearSomeCountUser(double myLng,double myLat,int myUserId,int start,String sex,double distance,
			List<UserInfo> userInfos,List<UserLocation> userLocations,int count,String timeline){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null;
    		PreparedStatement pstmt = null;
    		
    		String sexSql = "";

    		if(!sex.equals("")) 
    			sexSql = "a.sex="+"'"+sex+"' and ";
    		
			sql = "SELECT a.*,b.id as lid,b.userId as luserId,b.time,b.lng,b.lat,"
					+ "(6371.004*ACOS(SIN(?/180*PI())*SIN(b.lat/180*PI())+COS(?/180*PI())*COS(b.lat/180*PI())*COS((?-b.lng)/180*PI()))) As juli "
					+ "FROM userinfo AS a,userlocation AS b "
					+ "where "
					+ "(6371.004*ACOS(SIN(?/180*PI())*SIN(b.lat/180*PI())+COS(?/180*PI())*COS(b.lat/180*PI())*COS((?-b.lng)/180*PI())))< ? and "
					+ sexSql
					+ " a.userId<> ? and a.userId=b.userId and b.time>? Order BY juli asc limit ?,?";
			pstmt=conn.prepareStatement(sql); 
		    pstmt.setDouble(1, myLat);
		    pstmt.setDouble(2, myLat);
		    pstmt.setDouble(3, myLng);
		    pstmt.setDouble(4, myLat);
		    pstmt.setDouble(5, myLat);
		    pstmt.setDouble(6, myLng);
		    pstmt.setDouble(7, distance/1000);
		    pstmt.setInt(8, myUserId);
		    pstmt.setString(9, timeline);
		    pstmt.setInt(10, start);
		    pstmt.setInt(11, count);
		    ResultSet rs=pstmt.executeQuery(); 
		   
		    //遍历每条数据
		    while (rs.next()) {
			    UserInfo userInfo = new UserInfo();
		    	userInfo.setId(rs.getInt("id"));
		    	userInfo.setUserId(rs.getInt("userId"));
		    	userInfo.setNickName(rs.getString("nickName"));
		    	userInfo.setRealName(rs.getString("realName"));
		    	userInfo.setSex(rs.getString("sex"));
		    	userInfo.setLoveNum(rs.getInt("loveNum"));
		    	userInfo.setPopularityNum(rs.getInt("popularityNum"));
		    	userInfos.add(userInfo);
		    	
		    	UserLocation userLocation = new UserLocation();
		    	userLocation.setId(rs.getInt("lid"));
		    	userLocation.setUserId(rs.getInt("luserId"));
		    	userLocation.setLng(rs.getDouble("lng"));
		    	userLocation.setLat(rs.getDouble("lat"));
		    	userLocation.setTime(rs.getLong("time"));
		    	userLocations.add(userLocation);
		    }
		    return start+userInfos.size();
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

	
	public List<UserInfo> searchUser(String searchString){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = null;
    		PreparedStatement pstmt = null;
    		char first=searchString.toUpperCase().charAt(0);
    		if(first>=65&&first<=90)//英文字母
    		{
    			searchString=ChineseInitial.getPYIndexStr(searchString, true);
        		System.out.println(searchString);
        			sql = "SELECT * from userinfo "
        					+ "where get_first_pinyin_char(realName) like \'%"+searchString+"%\' "
        							+ "or get_first_pinyin_char(nickName) like \'%"+searchString+"%\'";
    		}
    		else
    			sql = "SELECT * from userinfo where realName like \'%"+searchString+"%\' or nickName like \'%"+searchString+"%\'";
		    pstmt=conn.prepareStatement(sql); 
		
		    ResultSet rs=pstmt.executeQuery(); 
		    
		    List<UserInfo> userInfos = new ArrayList<UserInfo>();
		    //遍历每条数据
		    while (rs.next()) {
			    UserInfo userInfo = new UserInfo();
		    	userInfo.setId(rs.getInt("id"));
		    	userInfo.setUserId(rs.getInt("userId"));
		    	userInfo.setNickName(rs.getString("nickName"));
		    	userInfo.setRealName(rs.getString("realName"));
		    	userInfo.setSex(rs.getString("sex"));
		    	userInfo.setLoveNum(rs.getInt("loveNum"));
		    	userInfo.setPopularityNum(rs.getInt("popularityNum"));
		    	userInfos.add(userInfo);
		    }
		    return userInfos;
		
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

