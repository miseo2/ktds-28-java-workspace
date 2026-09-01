package com.ktdsuniversity.edu.tmdb.mv.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.appr.vo.ApprVO;
import com.ktdsuniversity.edu.tmdb.bckgrd.vo.BckgrdVO;
import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;
import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.kwrd.vo.KwrdVO;
import com.ktdsuniversity.edu.tmdb.pstr.vo.PstrVO;
import com.ktdsuniversity.edu.tmdb.vd.vo.VdVO;

public class MvVO {
	
	private String mvId;
	private String ttl;
	private String mvRtng;
	private int rnngTm;
	private String rlsDt;
	private String smmr;
	private String mainPstrUrl;
	private String fbUrl;
	private String xUrl;
	private String instaUrl;
	private String tgln;
	private String orgnlTtl;
	private String plyng;
	private String orgnlLngg;
	private long btgt;
	private long bxOffcRvn;
	
	// 하나의 영화는 여러 개의 동영상을 가지고 있다.
	private List<VdVO> vdList;
	
	// 하나의 영화는 여러 개의 배경을 가지고 있다.
	private List<BckgrdVO> bckgrdList;
	
	// 하나의 영화는 여러 개의 포스터를 가지고 있다.
	private List<PstrVO> pstrList;
	
	// 하나의 영화는 여러명이 제작했다.
	private List<FlmmkrVO> flmmkrList;
	// 하나의 영화에 여러명이 출연했다.
	private List<ApprVO> apprList;
	
	// 하나의 영화는 여러개의 장르가 있다.
	private List<GnrVO> gnrlList;
	// 하나의 영화는 여러개의 키워드가 있다.
	
	private List<KwrdVO> kwrdList;
	
	
	
	public List<VdVO> getVdList() {
		return this.vdList;
	}
	public List<BckgrdVO> getBckgrdList() {
		return this.bckgrdList;
	}
	public List<PstrVO> getPstrList() {
		return this.pstrList;
	}
	
	public void setVdList(List<VdVO> vdList) {
		this.vdList = vdList;
	}
	public void setBckgrdList(List<BckgrdVO> bckgrdList) {
		this.bckgrdList = bckgrdList;
	}
	public void setPstrList(List<PstrVO> pstrList) {
		this.pstrList = pstrList;
	}
	public String getMvId() {
		return this.mvId;
	}
	public String getTtl() {
		return this.ttl;
	}
	public String getMvRtng() {
		return this.mvRtng;
	}
	public int getRnngTm() {
		return this.rnngTm;
	}
	public String getRlsDt() {
		return this.rlsDt;
	}
	public String getSmmr() {
		return this.smmr;
	}
	public String getMainPstrUrl() {
		return this.mainPstrUrl;
	}
	public String getFbUrl() {
		return this.fbUrl;
	}
	public String getxUrl() {
		return this.xUrl;
	}
	public String getInstaUrl() {
		return this.instaUrl;
	}
	public String getTgln() {
		return this.tgln;
	}
	public String getOrgnlTtl() {
		return this.orgnlTtl;
	}
	public String getPlyng() {
		return this.plyng;
	}
	public String getOrgnlLngg() {
		return this.orgnlLngg;
	}
	public long getBtgt() {
		return this.btgt;
	}
	public long getBxOffcRvn() {
		return this.bxOffcRvn;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	public void setMvRtng(String mvRtng) {
		this.mvRtng = mvRtng;
	}
	public void setRnngTm(int rnngTm) {
		this.rnngTm = rnngTm;
	}
	public void setRlsDt(String rlsDt) {
		this.rlsDt = rlsDt;
	}
	public void setSmmr(String smmr) {
		this.smmr = smmr;
	}
	public void setMainPstrUrl(String mainPstrUrl) {
		this.mainPstrUrl = mainPstrUrl;
	}
	public void setFbUrl(String fbUrl) {
		this.fbUrl = fbUrl;
	}
	public void setXUrl(String xUrl) {
		this.xUrl = xUrl;
	}
	public void setInstaUrl(String instaUrl) {
		this.instaUrl = instaUrl;
	}
	public void setTgln(String tgln) {
		this.tgln = tgln;
	}
	public void setOrgnlTtl(String orgnlTtl) {
		this.orgnlTtl = orgnlTtl;
	}
	public void setPlyng(String plyng) {
		this.plyng = plyng;
	}
	public void setOrgnlLngg(String orgnlLngg) {
		this.orgnlLngg = orgnlLngg;
	}
	public void setBtgt(long btgt) {
		this.btgt = btgt;
	}
	public void setBxOffcRvn(long bxOffcRvn) {
		this.bxOffcRvn = bxOffcRvn;
	}
	
	public List<FlmmkrVO> getFlmmkrList() {
		return this.flmmkrList;
	}
	public void setFlmmkrList(List<FlmmkrVO> flmmkrList) {
		this.flmmkrList = flmmkrList;
	}
	public List<ApprVO> getApprList() {
		return this.apprList;
	}
	public void setApprList(List<ApprVO> apprList) {
		this.apprList = apprList;
	}
	public List<GnrVO> getGnrlList() {
		return this.gnrlList;
	}
	public void setGnrlList(List<GnrVO> gnrlList) {
		this.gnrlList = gnrlList;
	}
	public List<KwrdVO> getKwrdList() {
		return this.kwrdList;
	}
	public void setKwrdList(List<KwrdVO> kwrdList) {
		this.kwrdList = kwrdList;
	}
	
	@Override
	public String toString() {
		return "MvVO [mvId=" + mvId + ", ttl=" + ttl + ", mvRtng=" + mvRtng + ", rnngTm=" + rnngTm + ", rlsDt=" + rlsDt
				+ ", smmr=" + smmr + ", mainPstrUrl=" + mainPstrUrl + ", fbUrl=" + fbUrl + ", xUrl=" + xUrl
				+ ", instaUrl=" + instaUrl + ", tgln=" + tgln + ", orgnlTtl=" + orgnlTtl + ", plyng=" + plyng
				+ ", orgnlLngg=" + orgnlLngg + ", btgt=" + btgt + ", bxOffcRvn=" + bxOffcRvn + "]";
	}
	
	

}
