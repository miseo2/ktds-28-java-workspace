-- 새로운 시퀀스 발급하기
SELECT TEST_SEQ.NEXTVAL
     , CACHED_SEQ.NEXTVAL
  FROM DUAL
;

-- 시퀀스들의 현재값 출력해보기
SELECT TEST_SEQ.CURRVAL
     , CACHED_SEQ.CURRVAL
  FROM DUAL
;

SELECT *
  FROM  MV
;

ROLLBACK;

COMMIT;

INSERT INTO MV 
 (MV_ID
, TTL
, MV_RTNG
, RNNG_TM
, RLS_DT
, SMMR
, MAIN_PSTR_URL
, FB_URL
, X_URL
, INSTA_URL
, TGLN
, ORGN_TTL
, PLYNG
, ORGN_LNGG
, BDGT
, BX_OFFC_RVN)
VALUES 
 (SEQ_MV_PK.NEXTVAL || '-spider-man-brand-new-day'
, '스파이더맨: 브랜드 뉴데이 '
, '12'
, 145
, TO_DATE('2026/07/29', 'YYYY/MM/DD')
, '4년 전 소중한 사람들을 지키기 위해 모두의 기억에서 사라진 피터 파커. 친절한 이웃 스파이더맨으로서 뉴욕을 지키며 고독한 삶을 살아가던 피터는 어느 날, 예상치 못한 DNA 변이로 인해 통제 불가능한 힘에 사로잡히고 그의 진짜 정체를 알고 있는 적까지 마주하게 된다. 타인의 의식을 조종하는 정체불명의 존재로 인해 모두가 피터를 노리는 적이 될 수 있는 혼란 속에서 피터는 다시 위협에 빠진 MJ와 모두를 지키기 위해 스파이더맨으로 그들 앞에 서게 되는'
, 'POSTER-URL'
, 'https://www.facebook.com/SpiderManMovie'
, 'https://x.com/SpiderManMovie'
, 'https://www.instagram.com/spidermanmovie/'
, '스파이더맨의 새로운 날을 확인하라!'
, 'Spider-Man: Brand New Day'
, '개봉됨'
, '영어'
, 225000000
, 2219901026)
;

INSERT INTO GNR 
 (GNR_ID
, NM)
VALUES 
 (SEQ_GNR_PK.NEXTVAL || '-adventure'
 , '모험')
;

SELECT *
  FROM GNR
;

INSERT INTO MV_GNR 
 (MV_GNR_ID
, MV_ID
, GNR_ID2)
VALUES
 ('MG-' || TO_CHAR(SYSDATE, 'YYYYMMDD-') || LPAD(SEQ_MV_GNR_PK.NEXTVAL, 6, '0')
, '1-spider-man-brand-new-day'
, '3-adventure')
;

SELECT *
  FROM MV_GNR
;

