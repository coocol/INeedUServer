package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eethan.ineedu.databasebeans.FlowerFan;
import com.eethan.ineedu.databasebeans.LovePopularityIncrease;


public class LovePopularityIncreaseDAO extends DAO<LovePopularityIncrease>{
	public static String TABLE_NAME = "lovepopularityincrease";
	private static Class myClass = LovePopularityIncrease.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String OLDLOVENUM = "oldLoveNum";
	public static final String OLDPOPULARITYNUM = "oldPopularityNum";
	public static final String INCREASELOVENUM = "increaseLoveNum";
	public static final String INCREASEPOPULARITYNUM = "increasePopularityNum";
	
	private Connection conn = null;
	
	public LovePopularityIncreaseDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	
	public void addToFlowerFans(FlowerFan flowerFan){
		Connection connection = null;
		try{
			connection = DatabasePool.getInstance().getConnection();
			String sql1 = "select ownerid from flowerfans where fansid = ? and ownerid =?";
			PreparedStatement statement = connection.prepareStatement(sql1);
			statement.setInt(1, flowerFan.getFansid());
			statement.setInt(2, flowerFan.getOwnerid());
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				resultSet.close();
				statement.close();
			}else{
				
				String sql2 = "insert into flowerfans (ownerid,fansid) values(?,?)";
				statement = connection.prepareStatement(sql2);
				statement.setInt(1, flowerFan.getOwnerid());
				statement.setInt(2, flowerFan.getFansid());
				statement.executeUpdate();
				statement.close();
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		
		
	}
}
