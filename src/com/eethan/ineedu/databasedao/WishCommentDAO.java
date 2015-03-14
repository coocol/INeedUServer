package com.eethan.ineedu.databasedao;

import com.eethan.ineedu.databasebeans.WishComment;

public class WishCommentDAO extends DAO<WishComment>{
	public static String TABLE_NAME = "wishcomment";
	private static Class myClass = WishComment.class;
	
	public static final String ID = "id";
	public static final String WISHID = "wishId";
	public static final String USERID = "userId";
	public static final String COMMENTEDUSERID = "commentedUserId";
	public static final String TIME = "time";
	public static final String CONTENT = "content";
	
	
	public WishCommentDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
