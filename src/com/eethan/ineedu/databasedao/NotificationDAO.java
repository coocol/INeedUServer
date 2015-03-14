package com.eethan.ineedu.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eethan.ineedu.constant.NotificationType;
import com.eethan.ineedu.databasebeans.Contact;
import com.eethan.ineedu.databasebeans.Notification;

public class NotificationDAO extends DAO<Notification>{
	public static String TABLE_NAME = "notification";
	private static Class myClass = Notification.class;
	private ContactDAO contactDAO = new ContactDAO();
	
	public static final String 	NOTIFICATIONID = "notificationId";
	public static final String USERID = "userId";
	public static final String NOTICEDID = "noticedId";
	public static final String TIME = "time";
	public static final String NOTICEFLAG = "noticeFlag";
	
	private Connection conn = null;

	public NotificationDAO() {
		// TODO Auto-generated constructor stub
		setTableName(TABLE_NAME);
		setClass(myClass);
		setTimeBug(true);
	}
	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		super.save(obj);
		Notification notification = (Notification) obj;
		int noticeId = notification.getUserId();
		int noticedId = notification.getNoticedId();
		String time = notification.getTime() + "";
		int type = Math.abs(notification.getNoticeFlag());
		if(Math.abs(type) == 
				NotificationType.POURLISTEN_COMMENT_WAIT)//Pourlisten是匿名的。。。
			return;
		//双向的
//		if(type==6 || type==10 || type==8 || type==12){
//			contactDAO.save(new Contact(noticeId, noticedId, type, time));
//			contactDAO.save(new Contact(noticedId, noticeId, type, time));
//		}
		
	}
	public void delete(Notification notification){
    	try {
    		conn = DatabasePool.getInstance().getConnection();
    		String sql="delete from notification where id=?"; 
		    PreparedStatement pstmt=conn.prepareStatement(sql); 
		    pstmt.setInt(1,notification.getId());
		    pstmt.executeUpdate(); 
    	} catch (Exception e){
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
	}
	public List<Notification> getAllNotification(int noticedId,int lastNum,int maxNum,boolean getMore)
	{
		try {
    		conn = DatabasePool.getInstance().getConnection();
    		ResultSet rs;
    		
    		if(getMore)
    		{
    			String sql="select * from notification "
    				+ "where noticedId =?"
    				+ " and id< ?"
    				+ " order by id desc"
    				+ " limit 0,?"; 
			    PreparedStatement pstmt=conn.prepareStatement(sql); 
			    pstmt.setObject(1,noticedId);
			    pstmt.setObject(2,lastNum);
			    pstmt.setObject(3,maxNum);
			    rs=pstmt.executeQuery(); 
    		}
    		else {
    			String sql="select * from notification "
        				+ "where noticedId=?"
        				+ " order by id desc"
        				+ " limit 0,?"; 
    			    PreparedStatement pstmt=conn.prepareStatement(sql); 
    			    pstmt.setObject(1,noticedId);
    			    pstmt.setObject(2,maxNum);
    			    rs=pstmt.executeQuery(); 
			}
		     //遍历每条数据
		    List<Notification> list = new ArrayList<Notification>();
		    while (rs.next()) {
		    	Notification notification = new Notification();
		    	notification.setId(rs.getInt("id"));
		    	notification.setNotificationId(rs.getInt("notificationId"));
		    	notification.setUserId(rs.getInt("userId"));
		    	notification.setNoticedId(rs.getInt("noticedId"));
		    	notification.setTime(rs.getLong("time"));
		    	notification.setNoticeFlag(rs.getInt("noticeFlag"));
		    	list.add(notification);
		    }
    		return list;
    	} catch (Exception e){
    	} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
    	return null;
	}
	
	
	
}
