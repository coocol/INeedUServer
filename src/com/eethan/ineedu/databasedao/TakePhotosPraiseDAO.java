package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.TakePhotosPraise;

public class TakePhotosPraiseDAO extends DAO<TakePhotosPraise>{
	public static final String TABLE_NAME = "takephotospraise";
	private static Class myClass = TakePhotosPraise.class;

	public static final String ID = "id";
	public static final String PHOTOID = "photoId";
	public static final String USERID = "userId";
	public static final String PRAISEDUSERID = "praisedUserId";
	
	
	
	private Connection conn = null;
	
	public TakePhotosPraiseDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
