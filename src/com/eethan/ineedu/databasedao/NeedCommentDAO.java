package com.eethan.ineedu.databasedao;

import java.sql.Connection;

import com.eethan.ineedu.databasebeans.NeedComment;


public class NeedCommentDAO extends DAO<NeedComment>{
	public static String TABLE_NAME = "needcomment";
	private static Class myClass = NeedComment.class;
	
	public static final String ID = "id";
	public static final String NEEDID = "needId";
	public static final String USERID = "userId";
	public static final String COMMENTUSERID = "commentedUserId";
	public static final String TIME = "time";
	public static final String COMMENT = "comment";
	
	private Connection conn = null;
	
	public NeedCommentDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
		setTimeBug(true);
	}
}
