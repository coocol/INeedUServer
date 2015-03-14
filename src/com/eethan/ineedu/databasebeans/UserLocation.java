package com.eethan.ineedu.databasebeans;

public class UserLocation{
	public int id;//用户位置信息唯一id
	public int userId;//用户的id和user表的id一致
	public double lng;//经度
	public double lat;//纬度
	
	public long time;
	

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public UserLocation() {
		// TODO Auto-generated constructor stub
	}
	
	public UserLocation(int id,int userId,double lng,double lat) {
		this.id = id;
		this.userId = userId;
		this.lng = lng;
		this.lat = lat;
	}
	
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public double getLng() {
		return lng;
	}
	public double getLat() {
		return lat;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	

}
