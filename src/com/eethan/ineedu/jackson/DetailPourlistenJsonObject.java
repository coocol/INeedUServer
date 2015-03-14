package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.PourListenNoSex;
import com.eethan.ineedu.databasebeans.Pourlisten;
import com.eethan.ineedu.databasebeans.PourlistenComment;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;


public class DetailPourlistenJsonObject {
	private Pourlisten pourlisten;
	private List<PourlistenComment> pourlistenComments;
	List<UserInfo> commUserInfos ;
	List<UserLocation> commUserLocations ;
	public List<UserInfo> getCommUserInfos() {
		return commUserInfos;
	}


	public void setCommUserInfos(List<UserInfo> commUserInfos) {
		this.commUserInfos = commUserInfos;
	}


	public List<UserLocation> getCommUserLocations() {
		return commUserLocations;
	}


	public void setCommUserLocations(List<UserLocation> commUserLocations) {
		this.commUserLocations = commUserLocations;
	}


	public DetailPourlistenJsonObject(){}
	

	public DetailPourlistenJsonObject(Pourlisten pourlisten,List<PourlistenComment> pourlistenComments,
			List<UserInfo> commUserInfos,List<UserLocation> commUserLocations){
		this.pourlisten = pourlisten;
		this.pourlistenComments = pourlistenComments;
		this.commUserInfos = commUserInfos;
		this.commUserLocations = commUserLocations;
	}
	
	public Pourlisten getPourlisten() {
		return pourlisten;
	}
	public List<PourlistenComment> getPourlistenComments() {
		return pourlistenComments;
	}
	public void setPourlisten(Pourlisten pourlisten) {
		this.pourlisten = pourlisten;
	}
	public void setPourlistenComments(List<PourlistenComment> pourlistenComments) {
		this.pourlistenComments = pourlistenComments;
	}
	
}
