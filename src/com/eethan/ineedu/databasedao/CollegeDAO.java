package com.eethan.ineedu.databasedao;

import java.sql.Connection;

import com.eethan.ineedu.databasebeans.City;
import com.eethan.ineedu.databasebeans.College;

public class CollegeDAO extends DAO<College>{

	public static String TABLE_NAME = "college";
	private static Class myClass = College.class;
	
	public static final String COID = "coid";
	public static final String PROVINCEID = "provinceID";
	public static final String NAME = "name";
	
	private Connection conn = null;
	
	public CollegeDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
