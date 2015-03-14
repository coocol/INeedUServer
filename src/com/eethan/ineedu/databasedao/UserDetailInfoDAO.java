package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.UserDetailInfo;

public class UserDetailInfoDAO extends DAO<UserDetailInfo>{
	public static String TABLE_NAME = "userdetailinfo";
	private static Class myClass = UserDetailInfo.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String SIGNATURE = "signature";
	public static final String SCHOOL = "school";
	public static final String ACADEMY = "academy";
	public static final String GRADE = "grade";
	
	private Connection conn = null;
	
	public UserDetailInfoDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
