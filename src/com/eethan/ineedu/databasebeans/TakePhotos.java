package com.eethan.ineedu.databasebeans;

public class TakePhotos {
	public int id;
	public int userId;
	public String content;
	public String time;
	public double lng;
	public double lat;
	public int praiseNum;
	public int transmitNum;//转发数
	public int transmitFrom;//从谁那里转发的
	public int transmitId;//转发的照片的ID
	public int commentNum;
	public String imageUrl;
	
	
	
	public TakePhotos(
			 int userId,
			 String content,
			 String time,
			 double lng,
			 double lat,
			 int praiseNum,
			 int transmitNum,
			 int transmitFrom,
			 int transmitId,
			 int commentNum,
			 String imageUrl) {
				
				this.userId =userId;
				this.content = content;
				this.time = time;
				this.lng = lng;
				this.lat = lat;
				this.praiseNum = praiseNum;
				this.transmitNum = transmitNum;
				this.setTransmitFrom(transmitFrom);
				this.transmitId = transmitId;
				this.commentNum = commentNum;
				this.imageUrl = imageUrl;
				
			}
	
	
	public TakePhotos() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}

	public int getTransmitNum() {
		return transmitNum;
	}

	public void setTransmitNum(int transmitNum) {
		this.transmitNum = transmitNum;
	}


	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getTransmitFrom() {
		return transmitFrom;
	}

	public void setTransmitFrom(int transmitFrom) {
		this.transmitFrom = transmitFrom;
	}

	public int getTransmitId() {
		return transmitId;
	}

	public void setTransmitId(int transmitId) {
		this.transmitId = transmitId;
	}
}
