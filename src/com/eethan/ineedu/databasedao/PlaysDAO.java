package com.eethan.ineedu.databasedao;

import java.sql.Connection;

import com.eethan.ineedu.databasebeans.Plays;

public class PlaysDAO extends DAO<Plays>{
	public static final String TABLE_NAME = "plays";
	private static Class myClass = Plays.class;

	public static final String ID="id";
	public static final String USERID="userId";
	public static final String INITTIME="initTime";
	public static final String DEADLINE="deadLine";
	public static final String TIME="time";//用户自己描述的时间
	public static final String LNG="lng";
	public static final String LAT="lat";
	public static final String THEME="theme";
	public static final String CONTENT="content";
	public static final String REQUIREMENT="requirement";
	public static final String PLACE="place";
	public static final String JOINNUM="joinNum";
	public static final String COMMENTNUM="commentNum";
	
	private Connection conn = null;
	
	public PlaysDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	
	
}
