package com.ktdsuniversity.edu.tmdb.vd.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class VdVO {
	
	private String vdId;
	private String vdUrl;
	private String mvId;
	
	// 하나의 영상은 하나의 영화를 위한 것이다.
	private MvVO mvVO;
	
	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}
	public MvVO getMvVO() {
		return this.mvVO;
	}
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
