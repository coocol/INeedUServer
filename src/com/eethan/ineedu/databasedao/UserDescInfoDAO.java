package com.eethan.ineedu.databasedao;

import java.sql.Connection;

import com.eethan.ineedu.databasebeans.UserDescInfo;
import com.eethan.ineedu.databasebeans.UserDetailInfo;

public class UserDescInfoDAO extends DAO<UserDescInfo>{

	public static String TABLE_NAME = "userdescinfo";
	private static Class myClass = UserDescInfo.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";

	
	public UserDescInfoDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
