package com.ktdsuniversity.edu.tmdb.vd.vo;

public class VdVO {
	
	private String vdId;
	private String vdUrl;
	private String mvId;
	
	
	public String getVdId() {
		return this.vdId;
	}
	public String getVdUrl() {
		return this.vdUrl;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setVdId(String vdId) {
		this.vdId = vdId;
	}
	public void setVdUrl(String vdUrl) {
		this.vdUrl = vdUrl;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	@Override
	public String toString() {
		return "VdVO [vdId=" + vdId + ", vdUrl=" + vdUrl + ", mvId=" + mvId + "]";
	}
	
	

}
