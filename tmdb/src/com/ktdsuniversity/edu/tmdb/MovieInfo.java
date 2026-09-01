package com.ktdsuniversity.edu.tmdb;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.appr.vo.ApprVO;
import com.ktdsuniversity.edu.tmdb.bckgrd.vo.BckgrdVO;
import com.ktdsuniversity.edu.tmdb.common.utils.DBConnector;
import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;
import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.kwrd.vo.KwrdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;
import com.ktdsuniversity.edu.tmdb.vd.vo.VdVO;

public class MovieInfo {
	
	private DBConnector connector;
	
	public MovieInfo () {
		this.connector = DBConnector.builder()
									.setDriverClassName("oracle.jdbc.driver.OracleDriver")
									.setUrl("jdbc:oracle:thin:@localhost:1521:XE")
									.setSchemaName("TMDB")
									.setPassword("TMDB")
									.connect();
	}
	
	public MvVO selectMovie(String mvId) {
		
		StringBuffer query = new StringBuffer();
		query.append("SELECT MV_ID                                ");
		query.append("     , TTL                                     ");
		query.append("     , MV_RTNG                                 ");
		query.append("     , RNNG_TM                                 ");
		query.append("     , TO_CHAR(RLS_DT , 'YYYY-MM-DD') AS RLS_DT");
		query.append("     , SMMR                                    ");
		query.append("     , MAIN_PSTR_URL                           ");
		query.append("     , FB_URL                                  ");
		query.append("     , X_URL                                   ");
		query.append("     , INSTA_URL                               ");
		query.append("     , TGLN                                    ");
		query.append("     , ORGN_TTL                                ");
		query.append("     , PLYNG                                   ");
		query.append("     , ORGN_LNGG                               ");
		query.append("     , BDGT                                    ");
		query.append("     , BX_OFFC_RVN                             ");
		query.append("  FROM MV                                      ");
		query.append(" WHERE DEL_YN = 'N'                            ");
		query.append("  AND MV_ID  = ?                              ");
		
		return connector.selectBuilder(MvVO.class, query)
						 .setParams(pstmt -> pstmt.setString(1, mvId))
						 .selectOne();
	}
	public void setGenres(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT G.GNR_ID             ");
	    query.append("     , G.NM                 ");
	    query.append("  FROM GNR G                ");
	    query.append(" INNER JOIN MV_GNR MG       ");
	    query.append("    ON G.GNR_ID = MG.GNR_ID2"); 
	    query.append(" WHERE MG.MV_ID = ?         ");
		
	    List<GnrVO> genres = this.connector.selectBuilder(GnrVO.class, query)
	    								   .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
	    								   .selectList();
	    movie.setGnrlList(genres);
	}
	public void setKeywords(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT K.KWRD_ID                ");
		query.append("     , K.KWRD                   ");
		query.append("  FROM KWRD K                   ");
		query.append(" INNER JOIN MV_KWRD MK          ");
		query.append("    ON K.KWRD_ID = MK.MV_KWRD_ID"); 
		query.append(" WHERE MK.MV_ID = ?             ");
		
		List<KwrdVO> kwrds = this.connector.selectBuilder(KwrdVO.class, query)
										    .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
											.selectList();
		movie.setKwrdList(kwrds);
	}
	
	public void setVideos(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT V.VD_ID          ");
		query.append("     , V.VD_URL         ");
		query.append("  FROM VD V             ");
		query.append(" INNER JOIN MV M        ");
		query.append("    ON V.MV_ID = M.MV_ID"); 
		query.append(" WHERE M.MV_ID = ?  ");
		
		List<VdVO> vds = this.connector.selectBuilder(VdVO.class, query)
										.setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
										.selectList();
	}
	
	public void setBackgrounds(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT B.BCKGRND_ID     ");
		query.append("     , B.BCKGRD_URL     ");
		query.append("  FROM BCKGRND B        ");
		query.append(" INNER JOIN MV M        ");
		query.append("    ON M.MV_ID = B.MV_ID"); 
		query.append(" WHERE M.MV_ID = ?      ");
		
		List<BckgrdVO> bckgrds = this.connector.selectBuilder(BckgrdVO.class, query)
												.setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
												.selectList();
	}
	
	public void setPosters(MvVO movie) {
		
	}
	
	public void setCasts(MvVO movie) {
		// 출연진 조회 MV has a APPR
		final StringBuffer query = new StringBuffer();
		query.append("SELECT APPR_ID      ");
		query.append("     , INVLVD_ID    ");
		query.append("     , MV_ID        ");
		query.append("     , RL           ");
		query.append("  FROM APPR         ");
		query.append(" WHERE MV_ID = ?    ");
		
		List<ApprVO> appers = this.connector.selectBuilder(ApprVO.class, query)
											.setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
											.selectList();
		movie.setApprList(appers);
		
//		query = new StringBuffer();
		query.delete(0, query.length());
		query.append("SELECT INVLVD_ID     ");
		query.append("     , INVLVD_PRFL   ");
		query.append("     , NM            ");
		query.append("  FROM INVLVD        ");
		query.append(" WHERE INVLVD_ID = ? ");
		
		//Appr has a Invlvd
		appers.forEach(appr -> {
			// 람다 함수 내부에서는 외부의 지역 변수를 사용할 수 없다.
			// 람다 함수 내부에서 사용할 수 있는 것? => 람다 내부의 지역변수, 람다 외부의 상수, 멤버변수
 			InvlvdVO invlvd = this.connector.selectBuilder(InvlvdVO.class, query)
											 .setParams(pstmt -> pstmt.setString(1, appr.getInvlvdId()))
											 .selectOne();
			appr.setInvlvdVO(invlvd);
		});
	}
	
	public void setFilmmakers(MvVO movie) {
		// 제작진 조회 Mv has a Flmmkr
		final StringBuffer query = new StringBuffer();
		query.append("SELECT FLMMKR_ID       ");
		query.append("     , FLMMKR          ");
		query.append("     , MV_ID           ");
		query.append("     , PRT             ");
		query.append("  FROM FLMMR           ");
		query.append(" WHERE MV_ID  = ?      ");
		
		List<FlmmkrVO> flmmkrs = this.connector.selectBuilder(FlmmkrVO.class, query)
											 .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
											 .selectList();
		movie.setFlmmkrList(flmmkrs);
		
		query.delete(0, query.length());
		query.append("SELECT INVLVD_ID     ");
		query.append("     , INVLVD_PRFL   ");
		query.append("     , NM            ");
		query.append("  FROM INVLVD        ");
		query.append(" WHERE INVLVD_ID = ? ");
		// Flmmkr has a Invlvd 
		flmmkrs.forEach(flmmkr -> {
			// 람다 함수 내부에서는 외부의 지역 변수를 사용할 수 없다.
			// 람다 함수 내부에서 사용할 수 있는 것? => 람다 내부의 지역변수, 람다 외부의 상수, 멤버변수
 			InvlvdVO invlvd = this.connector.selectBuilder(InvlvdVO.class, query)
											 .setParams(pstmt -> pstmt.setString(1, flmmkr.getInvlvdId()))
											 .selectOne();
			flmmkr.setInvlvdVO(invlvd);
		});
		
	}
	
	public static void main(String[] args) {
		MovieInfo movieInfo = new MovieInfo();
		
		MvVO movie = movieInfo.selectMovie("1-spider-man-brand-new-day");
		System.out.println(movie);
		
		System.out.println("장르명");
		movie.getGnrlList().forEach(gnr -> System.out.println(gnr.getNm()));
		
		System.out.println();
		System.out.println("=".repeat(70));
		System.out.println("출연 배우");
		movie.getApprList().forEach(appr -> {
			System.out.println(" " + appr.getInvlvdVO().getNm() + " - " + appr.getRl());
		});
		//app 종료 직전 모든 connection close
		movieInfo.connector.close();
	}

}
