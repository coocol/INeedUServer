package com.eethan.ineedu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eethan.ineedu.databasedao.DatabasePool;


public class TimerServlet extends HttpServlet{
	
	private static boolean isFirst = true;
	private Timer timer = new Timer(true);
	
	private TimerTask task = new TimerTask() {   
		public void run() {   
		//每天更新一下 lovepopularityincrease表
			updataLovePopularityIncrease();
		}   
	};  


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH); 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		if (hour>3) {
			date=+1;
		}
		hour = 3;//晚上3点
		c.clear();
		c.set(year, month, date, hour, 0);
		timer.schedule(task,c.getTime(), 24*60*60*1000);
		super.init();
	}
	
	private void updataLovePopularityIncrease(){
		if(isFirst)//每次重启都会马上调用，过滤掉此次调用
		{
			isFirst = false;
			return;
		}
		Connection conn = null;
		try {
			conn = DatabasePool.getInstance().getConnection();
			Statement statement = conn.createStatement();
			String sql = "update userinfo as a,lovepopularityincrease as b "
				+ "set b.increaseLoveNum=a.loveNum-b.oldLoveNum,"
				+ "b.increasePopularityNum=a.popularityNum-b.oldPopularityNum "
				+ "where a.userId=b.userId";
			statement.executeUpdate(sql);
			
			String sql2 = "update userinfo as a,lovepopularityincrease as b "
					+ "set b.oldLoveNum=a.loveNum,"
					+ "b.oldPopularityNum=a.popularityNum "
					+ "where a.userId=b.userId";
			statement.executeUpdate(sql2);
			System.out.println("Table lovepopularityincrease has update!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
    		try {
    			if (conn != null)
    				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
	}
	
	
   public void doPost(HttpServletRequest request,HttpServletResponse response)	
		   throws ServletException, IOException{
		updataLovePopularityIncrease();
   }
	    
  
   public void doGet(HttpServletRequest req,HttpServletResponse res) 
		   throws ServletException, IOException{
   		doPost(req,res);
   }

}