package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.PourlistenComment;

public class PourlistenCommentDAO extends DAO<PourlistenComment>{
	public static String TABLE_NAME = "pourlistencomment";
	private static Class myClass = PourlistenComment.class;
	
	public static final String ID = "id";
	public static final String POURLISTENID = "pourlistenId";
	public static final String USERID = "userId";
	public static final String COMMENTUSERID = "commentedUserId";
	public static final String TIME = "time";
	public static final String COMMENT = "comment";

	private Connection conn = null;
	
	public PourlistenCommentDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
		setTimeBug(true);
	}

}
