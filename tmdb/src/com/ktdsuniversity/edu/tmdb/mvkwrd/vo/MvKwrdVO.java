package com.ktdsuniversity.edu.tmdb.mvkwrd.vo;

public class MvKwrdVO {
	
	private String mvKwrd;
	private String kwrdId;
	private String mvId;
	public String getMvKwrd() {
		return this.mvKwrd;
	}
	public String getKwrdId() {
		return this.kwrdId;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setMvKwrd(String mvKwrd) {
		this.mvKwrd = mvKwrd;
	}
	public void setKwrdId(String kwrdId) {
		this.kwrdId = kwrdId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	@Override
	public String toString() {
		return "MvKwrdVO [mvKwrd=" + mvKwrd + ", kwrdId=" + kwrdId + ", mvId=" + mvId + "]";
	}
	
	

}
