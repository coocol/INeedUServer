package com.eethan.ineedu.databasebeans;

public class Plays {
	public int id;
	public int userId;
	public String initTime;
	public String deadLine;
	public String time;//用户自己描述的时间
	public double lng;
	public double lat;
	public 	String theme;
	public String content;
	public String requirement;
	public String place;
	public int joinNum;
	public int commentNum;
	
	public Plays(
	 int userId,
	 String initTime,
	 String deadLine,
	 String time,//用户自己描述的时间
	 double lng,
	 double lat,
	 	String theme,
	 String content,
	 String requirement,
	 String place,
	 int joinNum,
	 int commentNum) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		this.setInitTime(initTime);
		this.setDeadLine(deadLine);
		this.time = time;
		this.lng = lng;
		this.lat = lat;
		this.theme = theme;
		this.content = content;
		this.requirement = requirement;
		this.place = place;
		this.joinNum = joinNum;
		this.commentNum = commentNum;
		
	}
	public Plays() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getJoinNum() {
		return joinNum;
	}

	public void setJoinNum(int joinNum) {
		this.joinNum = joinNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getInitTime() {
		return initTime;
	}
	public void setInitTime(String initTime) {
		this.initTime = initTime;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
}
