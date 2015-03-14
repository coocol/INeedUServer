package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import com.eethan.ineedu.databasebeans.Province;

public class ProvinceDAO extends DAO<Province>{

	public static String TABLE_NAME = "province";
	private static Class myClass = Province.class;
	
	public static final String PID = "pid";
	public static final String PROVINCEID = "provinceID";
	public static final String PNAME = "pname";
	
	private Connection conn = null;
	
	public ProvinceDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
