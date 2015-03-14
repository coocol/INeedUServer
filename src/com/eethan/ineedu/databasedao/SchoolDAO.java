package com.eethan.ineedu.databasedao;

import java.sql.Connection;

import com.eethan.ineedu.databasebeans.City;
import com.eethan.ineedu.databasebeans.School;

public class SchoolDAO extends DAO<School>{

	public static String TABLE_NAME = "school";
	private static Class myClass = School.class;
	
	public static final String SCID = "scid";
	public static final String COLLEGEID = "collegeID";
	public static final String NAME = "name";
	
	private Connection conn = null;
	
	public SchoolDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
