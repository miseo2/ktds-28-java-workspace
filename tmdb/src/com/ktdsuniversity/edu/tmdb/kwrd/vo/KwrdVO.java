package com.ktdsuniversity.edu.tmdb.kwrd.vo;

public class KwrdVO {
	
	private String kwrdId;
	private String kwrd;
	
	
	public String getKwrdId() {
		return this.kwrdId;
	}
	public String getKwrd() {
		return this.kwrd;
	}
	public void setKwrdId(String kwrdId) {
		this.kwrdId = kwrdId;
	}
	public void setKwrd(String kwrd) {
		this.kwrd = kwrd;
	}
	@Override
	public String toString() {
		return "KwrdVO [kwrdId=" + kwrdId + ", kwrd=" + kwrd + "]";
	}

	
	
}
