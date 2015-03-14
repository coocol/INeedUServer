package com.eethan.ineedu.databasedao;

import com.eethan.ineedu.databasebeans.Album;

public class AlbumDAO extends DAO<Album>{

	public static String TABLE_NAME = "album";
	private static Class myClass = Album.class;
	
	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String PHOTOURL = "photoUrl";

	public AlbumDAO() {
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
}
