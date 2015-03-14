package com.eethan.ineedu.databasebeans;


public class NeedReport {
	public int id;//每一条举报唯一id
	public int needId;//对应need中的id，及那一条需求
	public int userId;//谁举报的
	public int reportedUserId;//对谁发出的举报
	public long time;//举报的时间
	public String report;//举报内容
	
	
	public NeedReport(){}
	
	public NeedReport(int id, int needId,
			int userId, int reportedUserId,long time, String report) {
		this.id = id;
		this.needId = needId;
		this.userId = userId;
		this.reportedUserId = reportedUserId;               
		this.time = time;
		this.report = report;
	}
	
	public int getId() {
		return id;
	}
	public int getNeedId() {
		return needId;
	}
	public int getUserId() {
		return userId;
	}
	public int getReportedUserId() {
		return reportedUserId;
	}
	public long getTime() {
		return time;
	}
	public String getReport() {
		return report;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNeedId(int needId) {
		this.needId = needId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setCommentedUserId(int reportedUserId) {
		this.reportedUserId = reportedUserId;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public void setComment(String report) {
		this.report = report;
	}
		
	
}
