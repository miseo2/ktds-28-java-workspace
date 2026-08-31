package com.ktdsuniversity.edu.tmdb.invlvd.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class InvlvdVO {
	
	private String invlvdId;
	private String invlvdPrfl;
	private String nm;
	
	//  참여자 한 명이 여러 개의 영화를 제작했다.
	private List<FlmmkrVO> flmmkrList;
	// 참여자 한 명이 여러개의 영화에 출연했다.
	private List<MvVO> mvVO;
	
	
	
	
	
	
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
	
	
	public List<FlmmkrVO> getFlmmkrList() {
		return this.flmmkrList;
	}
	public List<MvVO> getMvVO() {
		return this.mvVO;
	}
	
	
	public void setFlmmkrList(List<FlmmkrVO> flmmkrList) {
		this.flmmkrList = flmmkrList;
	}
	public void setMvVO(List<MvVO> mvVO) {
		this.mvVO = mvVO;
	}
	
	@Override
	public String toString() {
		return "InvlvdVO [invlvdId=" + invlvdId + ", invlvdPrfl=" + invlvdPrfl + ", nm=" + nm + "]";
	}
	
	
	

}
