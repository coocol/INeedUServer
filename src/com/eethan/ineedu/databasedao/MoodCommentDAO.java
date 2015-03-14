package com.eethan.ineedu.databasedao;

import java.sql.Connection;

import com.eethan.ineedu.databasebeans.MoodComment;
import com.eethan.ineedu.databasebeans.TakePhotosComment;

public class MoodCommentDAO extends DAO<MoodComment>{

	public static final String TABLE_NAME = "moodcomment";
	private static Class myClass = MoodComment.class;
	
	public static final String ID = "id";
	public static final String MOODID = "moodId";
	public static final String USERID = "userId";
	public static final String COMMENTEDUSERID = "commentedUserId";
	public static final String TIME = "time";
	public static final String CONTENT = "content";
	
	
	private Connection conn = null;
	
	public  MoodCommentDAO() {
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	
}
