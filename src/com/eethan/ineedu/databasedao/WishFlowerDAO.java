package com.eethan.ineedu.databasedao;

import java.sql.Connection;

import com.eethan.ineedu.databasebeans.TakePhotosPraise;
import com.eethan.ineedu.databasebeans.WishFlower;

public class WishFlowerDAO extends DAO<WishFlower>{
	public static final String TABLE_NAME = "wishflower";
	private static Class myClass = WishFlower.class;

	public static final String ID = "id";
	public static final String WISHID = "wishId";
	public static final String USERID = "userId";
	public static final String PRAISEDUSERID = "praisedUserId";
	
	
	
	private Connection conn = null;
	
	public WishFlowerDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
