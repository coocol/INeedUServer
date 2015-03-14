package com.eethan.ineedu.databasedao;


import com.eethan.ineedu.databasebeans.Wish;

public class WishDAO extends DAO<Wish>{
	public static String TABLE_NAME = "wish";
	private static Class myClass = Wish.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String CONTENT = "content";
	public static final String AUTH = "auth";
	public static final String TIME = "time";
	public static final String LNG = "lng";
	public static final String LAT = "lat";
	public static final String FLOWERNUM = "flowerNum";
	public static final String COMMENTNUM = "commentNum";
	public static final String IMAGEURL = "imageUrl";
	public static final String SOLVEID = "solveId";
	
	public WishDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
