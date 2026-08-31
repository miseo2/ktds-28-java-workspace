package com.ktdsuniversity.edu.tmdb.kwrd.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class KwrdVO {
	
	private String kwrdId;
	private String kwrd;
	
	//하나의 키워드는 여러개의 영화가 있다.
	private List<MvVO> mvVO; 
	
	public String getKwrdId() {
		return this.kwrdId;
	}
	public String getKwrd() {
		return this.kwrd;
	}
	public void setKwrdId(String kwrdId) {
		this.kwrdId = kwrdId;
	}
	public void setKwrd(String kwrd) {
		this.kwrd = kwrd;
	}
	@Override
	public String toString() {
		return "KwrdVO [kwrdId=" + kwrdId + ", kwrd=" + kwrd + "]";
	}

	
	
}
