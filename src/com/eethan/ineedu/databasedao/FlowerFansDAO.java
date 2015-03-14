package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eethan.ineedu.databasebeans.FlowerFan;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.util.ObjectToMap;
import com.mchange.v1.db.sql.PSManager;

public class FlowerFansDAO extends DAO<FlowerFan> {

	private final String TABLE_NAME = "flowerfans";
	private final Class MYCLASS = FlowerFan.class;

	public FlowerFansDAO(int ownerid) {
		setTableName(TABLE_NAME);
		setClass(MYCLASS);
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
	

	public java.util.List<FlowerFan> findByProperty(String propertyName, int value,int startId) {
		Connection conn = null;
		try {
			conn = DatabasePool.getInstance().getConnection();
    		String sql="select * from "+getTableName()+" where "+propertyName + "=?";
    		
		    PreparedStatement pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,value);
		    ResultSet rs=pstmt.executeQuery(); 
		     //遍历每条数据
		    List<FlowerFan> list = new ArrayList<FlowerFan>();
		    while (rs.next()) {
		    	Object obj = RSTravel(rs);
		    	list.add((FlowerFan) obj);
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
	};

	public List<UserInfo> getFansInfo(ArrayList<Integer> idList) {
		ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
		Connection conn = DatabasePool.getInstance().getConnection();
		if (idList != null && idList.size() > 0) {
			try {

				String sqlString = "select * from userinfo where userId = ?";
				PreparedStatement statement = conn.prepareStatement(sqlString);
				ResultSet resultSet = null;
				int num = idList.size();
				for (int i = 0; i < num; i++) {
					statement.setInt(1, idList.get(i));
					resultSet = statement.executeQuery();
					if(resultSet.next()){
						UserInfo userInfo = new UserInfo();
						userInfo.setId(resultSet.getInt("id"));
						userInfo.setUserId(resultSet.getInt("userId"));
						userInfo.setNickName(resultSet.getString("nickName"));
						userInfo.setRealName(resultSet.getString("realName"));
						userInfo.setSex(resultSet.getString("sex"));
						userInfo.setLoveNum(resultSet.getInt("loveNum"));
						userInfo.setPopularityNum(resultSet.getInt("popularityNum"));
						userInfos.add(userInfo);
					}
					
				}
				resultSet.close();
				statement.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		}
		return userInfos;
	}
}
