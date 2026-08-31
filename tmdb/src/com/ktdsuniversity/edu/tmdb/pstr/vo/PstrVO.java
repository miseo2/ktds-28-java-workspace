package com.ktdsuniversity.edu.tmdb.pstr.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class PstrVO {
	
	private String pstrId;
	private String pstrUrl;
	private String mvId;
	
	//하나의 포스터는 하나의 영화의 것이다.
	private MvVO mvVO;
	
	public String getPstrId() {
		return this.pstrId;
	}
	public String getPstrUrl() {
		return this.pstrUrl;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setPstrId(String pstrId) {
		this.pstrId = pstrId;
	}
	public void setPstrUrl(String pstrUrl) {
		this.pstrUrl = pstrUrl;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	@Override
	public String toString() {
		return "PstrVO [pstrId=" + pstrId + ", pstrUrl=" + pstrUrl + ", mvId=" + mvId + "]";
	}
	
	
	

}
