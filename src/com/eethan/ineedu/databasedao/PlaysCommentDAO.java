package com.eethan.ineedu.databasedao;

import java.sql.Connection;

import com.eethan.ineedu.databasebeans.PlaysComment;

public class PlaysCommentDAO extends DAO<PlaysComment>{
	public static String TABLE_NAME = "playscomment";
	private static Class myClass = PlaysComment.class;
	
	
	public static final String ID="id";
	public static final String PLAYSID="playsId";
	public static final String COMMENTEDUSERID="commentedUserId";
	public static final String TIME="time";
	public static final String CONTENT="content";
	
	
	private Connection conn = null;
	
	public PlaysCommentDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
