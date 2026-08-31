package com.ktdsuniversity.edu.tmdb.bckgrd.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class BckgrdVO {
	
	private String bckgrdId;
	private String bckgrdUrl;
	private String mdId;
	
	// 하나의 배경은 하나의 영화의 것이다.
	private MvVO mvVO;
	
	public MvVO getMvVO() {
		return this.mvVO;
	}
	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}
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
