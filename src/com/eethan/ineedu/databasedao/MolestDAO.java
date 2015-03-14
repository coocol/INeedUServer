package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.databasebeans.Contact;
import com.eethan.ineedu.databasebeans.Molest;

public class MolestDAO extends DAO<Molest>{
	public static String TABLE_NAME = "molest";
	private static Class myClass = Molest.class;
	
	public static final String MID = "mid";
	public static final String USERID = "userId";
	public static final String COMMENTEDUSERID = "commentedUserId";
	public static final String CONTENT = "content";
	public static final String TIME = "time";
	private Connection conn = null;
	
	public MolestDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	public List<Molest> getLastMolests(int num,int lastNum,boolean isGetMore)
	{
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql;
    		PreparedStatement pstmt;
    		if(isGetMore)
    		{
    			sql = "select * from "+getTableName()+" "
    					+"where mid < ? "
        				+"order by mid desc limit 0,?"
        				;
	    		pstmt = conn.prepareStatement(sql); 
	    		pstmt.setObject(1, lastNum);
	    		pstmt.setObject(2, num);
	    		pstmt.executeQuery();
    		}else{
    			sql = "select * from "+getTableName()+" "
        				+"order by mid desc limit 0,?"
        				;
        		
    		pstmt = conn.prepareStatement(sql); 
    		pstmt.setObject(1, num);
    		pstmt.executeQuery();
    		}
    		
		
		ResultSet rs=pstmt.executeQuery(); 
	     //遍历每条数据
	    List<Molest> list = new ArrayList<Molest>();
	    while (rs.next()) {
	    	Object obj = RSTravel(rs);
	    	list.add((Molest) obj);
	    }
		return list;
    	} catch (Exception e){
    		e.printStackTrace();
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
    		}
		return null;
	}
	
}
