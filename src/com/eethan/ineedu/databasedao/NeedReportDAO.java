package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.NeedComment;
import com.eethan.ineedu.databasebeans.NeedReport;

public class NeedReportDAO extends DAO<NeedReport>{
	public static String TABLE_NAME = "needreport";
	private static Class myClass = NeedReport.class;
	
	
	public static final String ID = "id";
	public static final String NEEDID = "needId";
	public static final String USERID = "userId";
	public static final String REPORTEDUSERID = "reportedUserId";
	public static final String TIME = "time";
	public static final String REPORT = "report";
	
	private Connection conn = null;
	
	public NeedReportDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
		setTimeBug(true);
	}
	
	public boolean check(NeedReport needReport){
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql="select * from needreport "
    				+ "where needId=? and userId=?"; 
		    PreparedStatement pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,needReport.getNeedId()); 
		    pstmt.setInt(2,needReport.getUserId());
		    ResultSet rs = pstmt.executeQuery(); 
		    if(rs.next()){
		    	return false;
		    }else {
				return true;
			}
    	} catch (Exception e){
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
    	return false;
	}
	
}
