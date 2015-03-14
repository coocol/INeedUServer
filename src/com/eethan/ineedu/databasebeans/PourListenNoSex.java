package com.eethan.ineedu.databasebeans;

public class PourListenNoSex {
	
	public int id;//一条倾诉倾听唯一ID
	public int  userId;//对应于user中id
	public String content ;//倾诉倾听内容
	public long time ;//时间		
	public double lng;//经度
	public double lat;//纬度
	public int commentNum ;//评论数目
	public String imageUrl;//背景图URL
	

	/** default constructor */
	public PourListenNoSex() {
	}

	

	/** full constructor */
	public PourListenNoSex(int id,int userId,String content,long time,double lng, double lat,int commentNum,String imageUrl) {
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.time = time;
		this.lng = lng;
		this.lat = lat;
		this.commentNum = commentNum;
		this.imageUrl = imageUrl;
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
	public int getCommentNum() {
		return commentNum;
	}
	public String getImageUrl() {
		return imageUrl;
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
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
