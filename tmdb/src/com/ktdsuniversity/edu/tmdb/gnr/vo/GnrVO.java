package com.ktdsuniversity.edu.tmdb.gnr.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class GnrVO {
	
	private String gnrId;
	private String nm;
	
	//하나의 장르는 여러개의 영화가 있다.
	private List<MvVO> mvVO; 
	
	public String getGnrId() {
		return this.gnrId;
	}
	public String getNm() {
		return this.nm;
	}
	public void setGnrId(String gnrId) {
		this.gnrId = gnrId;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	@Override
	public String toString() {
		return "GnrVO [gnrId=" + gnrId + ", nm=" + nm + "]";
	} 

	
}
