package com.ktdsuniversity.edu.tmdb.bckgrd.vo;

public class BckgrdVO {
	
	private String bckgrdId;
	private String bckgrdUrl;
	private String mdId;
	
	
	public String getBckgrdId() {
		return this.bckgrdId;
	}
	public String getBckgrdUrl() {
		return this.bckgrdUrl;
	}
	public String getMdId() {
		return this.mdId;
	}
	public void setBckgrdId(String bckgrdId) {
		this.bckgrdId = bckgrdId;
	}
	public void setBckgrdUrl(String bckgrdUrl) {
		this.bckgrdUrl = bckgrdUrl;
	}
	public void setMdId(String mdId) {
		this.mdId = mdId;
	}
	@Override
	public String toString() {
		return "BckgrdVO [bckgrdId=" + bckgrdId + ", bckgrdUrl=" + bckgrdUrl + ", mdId=" + mdId + "]";
	}
	
	
	
	

}
