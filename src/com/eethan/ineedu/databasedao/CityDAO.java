package com.eethan.ineedu.databasedao;

import java.sql.Connection;

import com.eethan.ineedu.databasebeans.City;

public class CityDAO extends DAO<City>{

	public static String TABLE_NAME = "city";
	private static Class myClass = City.class;
	
	public static final String CID = "cid";
	public static final String PROVINCEID = "provinceID";
	public static final String CITY = "city";
	public static final String CITYID = "cityID";
	
	private Connection conn = null;
	
	public CityDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
