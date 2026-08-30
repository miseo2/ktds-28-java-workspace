package com.ktdsuniversity.edu.tmdb.appr.vo;

public class ApprVO {
	
	private String apprID;
	private String invlvdId;
	private String mvId;
	private String rl;
	public String getApprID() {
		return this.apprID;
	}
	public String getInvlvdId() {
		return this.invlvdId;
	}
	public String getMvId() {
		return this.mvId;
	}
	public String getRl() {
		return this.rl;
	}
	public void setApprID(String apprID) {
		this.apprID = apprID;
	}
	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public void setRl(String rl) {
		this.rl = rl;
	}
	@Override
	public String toString() {
		return "ApprVO [apprID=" + apprID + ", invlvdId=" + invlvdId + ", mvId=" + mvId + ", rl=" + rl + "]";
	}

	
}
