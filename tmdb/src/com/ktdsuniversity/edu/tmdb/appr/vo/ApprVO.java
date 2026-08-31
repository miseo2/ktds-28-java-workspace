package com.ktdsuniversity.edu.tmdb.appr.vo;

import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class ApprVO {
	
	private String apprID;
	private String invlvdId;
	private String mvId;
	private String rl;
	
	// 출연자 한명이 하나의 영화에 출연했다.
	private MvVO mvVO;
	
	// 출연자 한명이 하나의 참여자이다.
	private InvlvdVO invlvdVO;
	
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
		return "ApprVO [apprID=" + apprID + ", invlvdId=" + invlvdId + ", mvId=" + mvId + ", rl=" + rl + "]";
	}

	
}
