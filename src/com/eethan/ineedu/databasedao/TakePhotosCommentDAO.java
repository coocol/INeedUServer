package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.TakePhotosComment;

public class TakePhotosCommentDAO extends DAO<TakePhotosComment>{
	public static final String TABLE_NAME = "takephotoscomment";
	private static Class myClass = TakePhotosComment.class;
	
	public static final String ID = "id";
	public static final String PHOTOID = "photoId";
	public static final String USERID = "userId";
	public static final String COMMENTEDUSERID = "commentedUserId";
	public static final String TIME = "time";
	public static final String CONTENT = "content";
	
	
	private Connection conn = null;
	
	public TakePhotosCommentDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	
}
