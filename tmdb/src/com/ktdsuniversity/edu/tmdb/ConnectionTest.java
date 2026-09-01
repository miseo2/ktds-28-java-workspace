package com.ktdsuniversity.edu.tmdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class ConnectionTest {
	
	public static MvVO selectMovie(String mvId) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("ojdc 드라이버가 발견되지 않았습니다.");
		}
		
		// java -> oracle 연결하기 위한 Url
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		// Oracle에 접속하기 위한 인증 정보
		String schemaName = "TMDB";
		String password = "TMDB";
		
		//Oracle로 접속
		Connection dbConnection = null;
		try {
			dbConnection = DriverManager.getConnection(url, schemaName, password);
			// 연결한 스키마 이름을 출력
			System.out.println(dbConnection.getSchema());
		} catch(SQLException sqle) {
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.", sqle);
		}
		
		//Oracle로 쿼리를 전송하고 실행 한 뒤 결과를 받아온다.
		//영화의 정보만 조회를 해본다.
		StringBuffer query = new StringBuffer();
		query.append("	SELECT MV_ID                                ");
		query.append("    , TTL                                     ");
		query.append("    , MV_RTNG                                 ");
		query.append("    , RNNG_TM                                 ");
		query.append("    , TO_CHAR(RLS_DT , 'YYYY-MM-DD') AS RLS_DT");
		query.append("    , SMMR                                    ");
		query.append("    , MAIN_PSTR_URL                           ");
		query.append("    , FB_URL                                  ");
		query.append("    , X_URL                                   ");
		query.append("    , INSTA_URL                               ");
		query.append("    , TGLN                                    ");
		query.append("    , ORGN_TTL                                ");
		query.append("    , PLYNG                                   ");
		query.append("    , ORGN_LNGG                               ");
		query.append("    , BDGT                                    ");
		query.append("    , BX_OFFC_RVN                             ");
		query.append(" FROM MV                                      ");
		query.append("WHERE DEL_YN = ?                              ");
		query.append("  AND MV_ID  = ?                              ");
		
		// 위에 준비된 쿼리를 Oracle에 전송하고 실행한다.
//		List<MvVO> movieList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = dbConnection.prepareStatement(query.toString());
			// ?에 들어갈 값을 할당한다.
			
			pstmt.setString(1, "N");
			pstmt.setString(2, mvId);
			rs = pstmt.executeQuery();
			
			// ResultSet의 ROW를 처음부터 끝까지 반복시킨다.
			MvVO mvVO = null;
			while(rs.next()) {
				// 현재 반복중인 ROW에서 각 컬럼들의 값을 추출한다.
				
				
				// 추출된 값을 MvVO에게 할당해준다.
				mvVO = new MvVO();
				mvVO.setMvId(rs.getString("MV_ID"));
				mvVO.setTtl(rs.getString("TTL"));
				mvVO.setMvRtng(rs.getString("MV_RTNG"));
				mvVO.setRnngTm(rs.getInt("RNNG_TM"));
				mvVO.setRlsDt(rs.getString("RLS_DT"));
				mvVO.setSmmr(rs.getString("SMMR"));
				mvVO.setMainPstrUrl(rs.getString("MAIN_PSTR_URL"));
				mvVO.setFbUrl(rs.getString("FB_URL"));
				mvVO.setxUrl(rs.getString("X_URL"));
				mvVO.setInstaUrl(rs.getString("INSTA_URL"));
				mvVO.setTgln(rs.getString("TGLN"));
				mvVO.setOrgnlTtl(rs.getString("ORGN_TTL"));
				mvVO.setPlyng(rs.getString("PLYNG"));
				mvVO.setOrgnlLngg(rs.getString("ORGN_LNGG"));
				mvVO.setBtgt(rs.getLong("BDGT"));
				mvVO.setBxOffcRvn(rs.getLong("BX_OFFC_RVN"));
				//MvVO를 List<MvVO>에게 추가한다.
//				movieList.add(mvVO);
			}
			
		} catch(SQLException sqle) {
			throw new RuntimeException("쿼리에 문제가 있습니다", sqle);
		} finally {
			//rs close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			
			//pstmt close
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			
			if(dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {}
			}
		}
//		return mvId;
//		movieList.forEach(System.out::println);
		
//		return null;
	}
	public static List<GnrVO> selectGenre(String mvId) {
		
		//java -> Oracle 연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		// Oracle에 연결을 위한 인증정보 들고오기
		String schemaName = "TMDB";
		String password = "TMDB";
		
		//Oracle에 접속
		Connection connectDb = null;
		try {
			connectDb = DriverManager.getConnection(url, schemaName, password);
		} catch (SQLException sqle) {
			throw new RuntimeException("데이터베이스에 연결하지못했습니다. ", sqle);
		}
		//Oracle로 쿼리를 전송하고 실행 한 뒤 결과를 받아온다.
		StringBuffer query = new StringBuffer();
		query.append("SELECT G.GNR_ID             ");
	    query.append("     , G.NM                 ");
	    query.append("  FROM GNR G                ");
	    query.append(" INNER JOIN MV_GNR MG       ");
	    query.append("    ON G.GNR_ID = MG.GNR_ID2"); 
	    query.append(" WHERE MG.MV_ID = ?         ");
		
	    // 위에 준비된 쿼리를 Oracle에 전송하고 실행한다.
	    PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = connectDb.prepareStatement(query.toString());
			pstmt.setString(1, mvId);
			
			rs = pstmt.executeQuery();
			// ResultSet의 ROW를 처음부터 끝까지 반복시킨다.
			GnrVO gnrVO = null;
			while(rs.next()) {
				gnrVO = new GnrVO();
				gnrVO.setGnrId("GNR_ID");
				gnrVO.setNm("NM");
			}
			
		} catch (SQLException sqle) {
			throw new RuntimeException("쿼리에 문제가 있습니다.")
		}
		
		

		
		
		
		return null;
	}
	
	public static void main(String[] args) {
		
		MvVO movie = selectMovie("1-spider-man-brand-new-day");
		System.out.println(movie);
				
		
		
		
//		List<MvVO> movies = 쿼리의 실행 결과;
		
	}

}
