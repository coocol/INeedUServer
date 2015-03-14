package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Pourlisten;


public class RefreshPourlistenJsonObject {
	private List<Pourlisten> pourlistens;
	
	public RefreshPourlistenJsonObject() {}
	

	public RefreshPourlistenJsonObject(List<Pourlisten> pourlistens) {
		this.pourlistens = pourlistens;
	}
	
	public List<Pourlisten> getPourlistens() {
		return pourlistens;
	}
	public void setPourlistens(List<Pourlisten> pourlistens) {
		this.pourlistens = pourlistens;
	}

}
