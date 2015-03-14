package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eethan.ineedu.databasebeans.Contact;
import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.PlaysParticipant;
import com.eethan.ineedu.util.ObjectToMap;

public class PlaysParticipantDAO extends DAO<PlaysParticipant>{
	public static final String TABLE_NAME = "playsparticipant";
	private static Class myClass = PlaysParticipant.class;
	
	public static final String ID="id";
	public static final String PLAYSID="playsId";
	public static final String USERID="userId";
	public static final String OWNERID="ownerId";
	
	
	private Connection conn = null;
	
	public PlaysParticipantDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
	}
	public boolean isExist(int userId ,int playId )
	{
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql = "select * from "+getTableName()+" "
    				+"where userId = ? and playsId = ?"
    				;
    		
		PreparedStatement pstmt=conn.prepareStatement(sql); 
		pstmt.setObject(1, userId);
		pstmt.setObject(2, playId);
		pstmt.executeQuery(); 
		
		ResultSet rs=pstmt.executeQuery(); 
	     //遍历每条数据
	    List<PlaysParticipant> list = new ArrayList<PlaysParticipant>();
	    while (rs.next()) {
	    	Object obj = RSTravel(rs);
	    	list.add((PlaysParticipant) obj);
	    }
	    if(list.size() == 0)
	    		return false;
		return true;
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
		return false;
	
	}
}
