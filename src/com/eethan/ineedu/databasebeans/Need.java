package com.eethan.ineedu.databasebeans;



public class Need{
	public int id;//一条求助唯一id
	public int userId;//对应于user中id
	public String content;//需求内容
	public long time;//时间
	public double lng;//需求所在经度（位置）
	public double lat;//需求纬度
	public long timeLimit;//限时
	public String reward;//报酬
	public int type;//需求类别
	public int reportNum;//举报数目
	public int commentNum;//被评论的数目
	public int solveId;//谁解决的,未解决为-1
	
	
	
	public Need(){
		
	}
	
	public Need(int id,int userId,String content,
			long time , double lng, double lat,
			long timeLimit, String reward,int type,
			int reportNum, int commentNum, int solveId) {	
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.time = time;
		this.lng = lng;
		this.lat = lat;
		this.timeLimit = timeLimit;
		this.reward = reward;
		this.type = type;
		this.reportNum = reportNum;
		this.commentNum = commentNum;
		this.solveId = solveId;
	}
	
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public String getContent() {
		return content;
	}
	public long getTime() {
		return time;
	}
	public double getLng() {
		return lng;
	}
	public double getLat() {
		return lat;
	}
	public long getTimeLimit() {
		return timeLimit;
	}
	public String getReward() {
		return reward;
	}
	public int getType() {
		return type;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public int getReportNum() {
		return reportNum;
	}
	public int getSolveId() {
		return solveId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public void setTimeLimit(long timeLimit) {
		this.timeLimit = timeLimit;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public void setSolveId(int solveId) {
		this.solveId = solveId;
	}
	
}
