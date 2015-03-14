package com.eethan.ineedu.databasebeans;

public class School {

	public School(){}
	
	public int scid;
	public String name;
	public int collegeID;
	public School(int scid, String name, int collegeID) {
		super();
		this.scid = scid;
		this.name = name;
		this.collegeID = collegeID;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCollegeID() {
		return collegeID;
	}
	public void setCollegeID(int collegeID) {
		this.collegeID = collegeID;
	}
}
