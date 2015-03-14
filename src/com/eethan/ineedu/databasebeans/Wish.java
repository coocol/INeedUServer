package com.eethan.ineedu.databasebeans;

public class Wish {
	public int id;
	public int userId;
	public String content;
	public int auth;
	public String time;
	public double lng;
	public double lat;
	public int flowerNum;
	public int commentNum;
	public int solveId;
	public String imageUrl;
	
	
	public Wish(int userId,String content,int auth,String time,
			double lng,double lat,int flowerNum,int commentNum,
			int solveId,String imageUrl){
		this.userId = userId;
		this.content = content;
		this.auth = auth;
		this.time = time;
		this.lng = lng;
		this.lat = lat;
		this.setFlowerNum(flowerNum);
		this.commentNum = commentNum;
		this.solveId = solveId;
		this.imageUrl = imageUrl;
		
	}
	public Wish(){}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
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
	
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getSolveId() {
		return solveId;
	}
	public void setSolveId(int solveId) {
		this.solveId = solveId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getFlowerNum() {
		return flowerNum;
	}
	public void setFlowerNum(int flowerNum) {
		this.flowerNum = flowerNum;
	}
	
}
