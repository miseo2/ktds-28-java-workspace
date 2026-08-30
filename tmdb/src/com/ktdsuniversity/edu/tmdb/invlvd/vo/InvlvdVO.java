package com.ktdsuniversity.edu.tmdb.invlvd.vo;

public class InvlvdVO {
	
	private String invlvdId;
	private String invlvdPrfl;
	private String nm;
	public String getInvlvdId() {
		return this.invlvdId;
	}
	public String getInvlvdPrfl() {
		return this.invlvdPrfl;
	}
	public String getNm() {
		return this.nm;
	}
	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}
	public void setInvlvdPrfl(String invlvdPrfl) {
		this.invlvdPrfl = invlvdPrfl;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	@Override
	public String toString() {
		return "InvlvdVO [invlvdId=" + invlvdId + ", invlvdPrfl=" + invlvdPrfl + ", nm=" + nm + "]";
	}
	
	
	

}
