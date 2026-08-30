package com.ktdsuniversity.edu.tmdb.pstr.vo;

public class PstrVO {
	
	private String pstrId;
	private String pstrUrl;
	private String mvId;
	
	
	public String getPstrId() {
		return this.pstrId;
	}
	public String getPstrUrl() {
		return this.pstrUrl;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setPstrId(String pstrId) {
		this.pstrId = pstrId;
	}
	public void setPstrUrl(String pstrUrl) {
		this.pstrUrl = pstrUrl;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	@Override
	public String toString() {
		return "PstrVO [pstrId=" + pstrId + ", pstrUrl=" + pstrUrl + ", mvId=" + mvId + "]";
	}
	
	
	

}
