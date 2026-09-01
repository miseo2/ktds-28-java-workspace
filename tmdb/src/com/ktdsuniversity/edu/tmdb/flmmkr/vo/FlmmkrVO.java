package com.ktdsuniversity.edu.tmdb.flmmkr.vo;

import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class FlmmkrVO {
	
	private String flmmkrId;
	private String invlvdId;
	private String mvId;
	private String flmmkr;
	private String prt;
	
	// 참여자 한 명이 하나의 영화를 제작했다.
	private MvVO mvVO;
	
	//제작자 한 명에 대한 참여자 정보
	private InvlvdVO invlvdVO;
	
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
	
	
	public MvVO getMvVO() {
		return this.mvVO;
	}
	public InvlvdVO getInvlvdVO() {
		return this.invlvdVO;
	}
	
	
	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}
	public void setInvlvdVO(InvlvdVO invlvdVO) {
		this.invlvdVO = invlvdVO;
	}
	@Override
	public String toString() {
		return "FlmmkrVO [flmmkrId=" + flmmkrId + ", invlvdId=" + invlvdId + ", mvId=" + mvId + ", flmmkr=" + flmmkr
				+ ", prt=" + prt + "]";
	}
	
	

}
