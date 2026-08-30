package com.ktdsuniversity.edu.tmdb.flmmkr.vo;

public class FlmmkrVO {
	
	private String flmmkrId;
	private String invlvdId;
	private String mvId;
	private String flmmkr;
	private String prt;
	public String getFlmmkrId() {
		return this.flmmkrId;
	}
	public String getInvlvdId() {
		return this.invlvdId;
	}
	public String getMvId() {
		return this.mvId;
	}
	public String getFlmmkr() {
		return this.flmmkr;
	}
	public String getPrt() {
		return this.prt;
	}
	public void setFlmmkrId(String flmmkrId) {
		this.flmmkrId = flmmkrId;
	}
	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public void setFlmmkr(String flmmkr) {
		this.flmmkr = flmmkr;
	}
	public void setPrt(String prt) {
		this.prt = prt;
	}
	@Override
	public String toString() {
		return "FlmmkrVO [flmmkrId=" + flmmkrId + ", invlvdId=" + invlvdId + ", mvId=" + mvId + ", flmmkr=" + flmmkr
				+ ", prt=" + prt + "]";
	}
	
	

}
