package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.UserInfo;

public class FlowerFansJsonObject {

	private List<UserInfo> fanslist;
	private int lastNum;

	public int getLastNum() {
		return lastNum;
	}

	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}

	public List<UserInfo> getFanslist() {
		return fanslist;
	}

	public void setFanslist(List<UserInfo> fanslist) {
		this.fanslist = fanslist;
	}

	
	
}
