package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import com.eethan.ineedu.databasebeans.UserLocation;

public class UserLocationDAO extends DAO<UserLocation>{
	public static String TABLE_NAME = "userlocation";
	private static Class myClass = UserLocation.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String LNG = "lng";
	public static final String LAT = "lat";

	private Connection conn = null;
	
	
	public UserLocationDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
		setTimeBug(true);
	}
}
