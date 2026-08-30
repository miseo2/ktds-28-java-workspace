-- UNION 규칙
-- 집합간의 컬럼 타입이 일치해야한다.
SELECT 1 AS NUM
     , 'A' AS STR
  FROM DUAL
 UNION
SELECT 2 
	 , 'B'
	 , SYSDATE 
  FROM DUAL
;

SELECT 1 AS NUM
  FROM DUAL
 UNION 
 SELECT 2
  FROM DUAL
 UNION ALL 
SELECT NUM2
  FROM (SELECT -1 AS NUM2
          FROM DUAL
         UNION ALL
        SELECT 0 AS NUM2
          FROM DUAL
         UNION ALL
        SELECT -7 AS NUM2
          FROM DUAL
         ORDER BY NUM2 ASC) 
;
  

-- CASE



WITH TEMP AS (
	SELECT 'Y' AS FLAG
	  FROM DUAL
	 UNION
	SELECT 'N'
	  FROM DUAL
	 UNION
	SELECT 'R'
	  FROM DUAL
	 UNION
	SELECT NULL 
	  FROM DUAL
)
-- TEMP 테이블의 FLAG 컬럼의 값이 
-- 'Y' 라면 'ON'으로 조회하고
-- 'R' 이라면 'READY'로 조회하고 
-- 아니라면 'OFF' 로 조회한다.
SELECT FLAG
     , CASE-- FLAG
           WHEN FLAG = 'Y' THEN
               'ON'
           WHEN FLAG = 'R' THEN
               'READY'
           WHEN FLAG IS NULL THEN
               'ERROR'
           ELSE
               'OFF'
       END AS ON_OFF
  FROM TEMP
;
    
--SELECT FLAG
--     , CASE
--           WHEN FLAG = 'Y' THEN
--               'ON'
--           WHEN FLAG = 'R' THEN
--               'READY'
--           ELSE
--               'OFF'
--       END AS ON_OFF
--  FROM TEMP
--;

SELECT FLAG
     , CASE FLAG
           WHEN 'Y' THEN
               'ON'
           WHEN 'R' THEN
               'READY'
           ELSE
               'OFF'
       END AS ON_OFF
  FROM TEMP
;

WITH NUMBERS AS (
	SELECT 10 AS NUM
	  FROM DUAL
	 UNION
	SELECT 20
	  FROM DUAL
	 UNION 
	SELECT 30
	  FROM DUAL
)
-- NUM 값이 30 이상이면 '3', 20 이상이면 '2', 10 이상이면 '1' 아니면 '0'으로 조회한다.
SELECT NUM
     , CASE
           WHEN NUM >= 30 THEN
               '3'
           WHEN NUM >= 20 THEN
               '2'
           WHEN NUM >= 10 THEN
               '1'
           ELSE
               '0'
       END AS RESULT    
  FROM NUMBERS 
;

-- 1. 사원의 사원 번호, 부서 번호, 근무 현황을 조회한다.
--       근무 현황: 근무하는 부서가 있을 경우 "근무 중", 아닐 경우 "발령 대기"
SELECT EMPLOYEE_ID 
     , DEPARTMENT_ID 
     , CASE
     	   WHEN DEPARTMENT_ID IS NOT NULL THEN
     	       '근무 중'
     	   ELSE
     	       '발령 대기'
       END AS "근무 현황"
  FROM EMPLOYEES
;
-- 2. 사원의 사원 번호, 입사일, 입사 순서를 조회한다.
--       입사 순서: 가장 빨리 입사한 사원은 "원년 사원", 가장 늦게 입사한 사원은 "신규 사원", 아닐 경우 "사원"
SELECT EMPLOYEE_ID 
     , HIRE_DATE
     , CASE HIRE_DATE
           WHEN (SELECT MAX(HIRE_DATE)
              	   FROM EMPLOYEES) THEN 
               '원년사원'
           WHEN (SELECT MIN(HIRE_DATE)
                   FROM EMPLOYEES) THEN
                '신규 사원'
           ELSE
               '사원'
       END AS "입사 순서"
  FROM EMPLOYEES
;
SELECT EMPLOYEE_ID 
     , HIRE_DATE 
  FROM EMPLOYEES 
 ORDER BY HIRE_DATE ASC 
;
SELECT EMPLOYEE_ID 
  FROM (SELECT EMPLOYEE_ID 
		     , HIRE_DATE 
		  FROM EMPLOYEES 
		 ORDER BY HIRE_DATE ASC )
;
     
-- LPAD, RPAD
SELECT 'A' AS LETTER
     , 10 AS NUM
--     , '111111111A'
     , LPAD('A', 10, '1')
     , LPAD(10, 10, '-')
     , RPAD('A', 10, '1')
     , RPAD(10, 10, '-')
     , 'ABCDEFGHIJKLMNOP' -- 16자리
     , LPAD('ABCDEFGHIJKLMNOP', 10, '!')
     , RPAD('ABCDEFGHIJKLMNOP', 10, '!')
     , 'ABCDEFGHIJ'
     , LPAD('ABCDEFGHIJ' , 10, '1')
  FROM DUAL
  
;

-- 2600, 4400, 13000, 6000
SELECT EMPLOYEE_ID 
     , SALARY 
     , SALARY / 1000
     , TRUNC(SALARY/1000) * 1000
  FROM EMPLOYEES
;



-- OUTER JOIN
-- 모든 사원들의 이름과 부서의 이름을 조회한다.
--   근무중인 부서가 없다면 null로 조회한다.
SELECT E.FIRST_NAME 
     , D.DEPARTMENT_NAME
  FROM EMPLOYEES E 
  LEFT OUTER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
;

-- 모든 부서이름별 근무중인 사원의 수를 조회한다.
--   근무중인 사원이 없다면 사원의 수를 0으로 조회한다.
SELECT D.DEPARTMENT_NAME 
     , COUNT(E.EMPLOYEE_ID )
  FROM DEPARTMENTS D
  LEFT OUTER JOIN EMPLOYEES E
    ON D.DEPARTMENT_ID  = E.DEPARTMENT_ID 
 GROUP BY D.DEPARTMENT_NAME 
;

SELECT D.DEPARTMENT_NAME 
     , COUNT(E.EMPLOYEE_ID )
  FROM EMPLOYEES E
 RIGHT OUTER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID  = E.DEPARTMENT_ID 
 GROUP BY D.DEPARTMENT_NAME
;

-- 모든 도시의 이름과 부서의 이름을 조회한다.
--   존재하는 부서가 없다면 null로 조회한다.
SELECT L.CITY 
	 , D.DEPARTMENT_NAME 
  FROM LOCATIONS L
  LEFT OUTER JOIN DEPARTMENTS D
    ON L.LOCATION_ID = D.LOCATION_ID 
;

-- 모든 국가의 이름과 도시의 이름을 조회한다.
--   존재하는 도시가 없다면 null로 조회한다.
SELECT C.COUNTRY_NAME 
     , L.CITY 
  FROM COUNTRIES C
  LEFT OUTER JOIN LOCATIONS L
    ON C.COUNTRY_ID  = L.COUNTRY_ID 
;

-- 모든 국가별 사원들의 평균 급여를 조회한다.
--   근무하는 사원이 없다면 평균급여를 0으로 조회한다.
SELECT C.COUNTRY_NAME 
     , NVL(AVG(E.SALARY ), 0)
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 INNER JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
 RIGHT OUTER JOIN COUNTRIES C
    ON L.COUNTRY_ID = C.COUNTRY_ID  
 GROUP BY C.COUNTRY_NAME 
;

-- 모든 도시의 이름, 도시에 존재하는 부서명, 부서에서 근무중인 사원명,
-- 사원이 수행하는 직무명을 조회한다.(138 ROWS)
-- 부서명, 사원명, 직무명이 없을 경우 NULL로 조회한다.
SELECT L.CITY  
     , D.DEPARTMENT_NAME 
     , E.FIRST_NAME 
     , J.JOB_TITLE 
  FROM EMPLOYEES E
 INNER JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID 
 RIGHT OUTER JOIN DEPARTMENTS D
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 RIGHT OUTER JOIN LOCATIONS L
    ON L.LOCATION_ID = D.LOCATION_ID 
;
  


-- Scala Query
-- 사원의 이름과 직무명을 조회한다. 이때, 직무 테이블은 INNER JOIN하지 않는다.
SELECT E.FIRST_NAME 
     , E.JOB_ID 
     , (SELECT J.JOB_TITLE 
          FROM JOBS J
         WHERE J.JOB_ID = E.JOB_ID )
  FROM EMPLOYEES E
;
-- 사원의 이름과 부서명을 조회한다. 이때, 부서 테이블은 INNER JOIN하지 않는다.
SELECT E.FIRST_NAME 
     , (SELECT D.DEPARTMENT_NAME 
     	  FROM DEPARTMENTS D
     	 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID )
  FROM EMPLOYEES E
;
-- 사원의 이름과 상사의 이름을 조회한다. 이때, 사원(상사) 테이블은 INNER JOIN하지 않는다.
SELECT E.FIRST_NAME 
     , (SELECT E_MAN.FIRST_NAME 
          FROM EMPLOYEES E_MAN
         WHERE E_MAN.EMPLOYEE_ID  = E.MANAGER_ID )
  FROM EMPLOYEES E
;

-- 사원의 이름과 급여, 전체 사원들의 평균 급여를 조회한다.
SELECT FIRST_NAME 
     , SALARY 
     , (SELECT AVG(SALARY )
          FROM EMPLOYEES )
  FROM EMPLOYEES
;

-- Sub query join
-- 사원이 근무중인 부서에서 최저 급여을 받는 사원의 이름, 급여, 부서번호를 조회한다.
SELECT FIRST_NAME 
     , SALARY 
     , DEPARTMENT_ID 
  FROM EMPLOYEES E
 WHERE SALARY = (SELECT MIN(SALARY)
 				   FROM EMPLOYEES E2
 				  WHERE E2.DEPARTMENT_ID = E.DEPARTMENT_ID )
;
-- 사원이 수행중인 직무에서 최저 급여를 받는 사원의 이름, 급여, 직무아이디를 조회한다.
SELECT FIRST_NAME 
     , SALARY 
     , JOB_ID 
  FROM EMPLOYEES E
 WHERE SALARY  = (SELECT MIN(SALARY)
     				FROM EMPLOYEES E2
     			   WHERE E2.JOB_ID = E.JOB_ID )
;
-- 사원이 근무중인 부서에서 부서장으로 근무하는 사원의 이름, 급여, 부서번호를 조회한다.
SELECT FIRST_NAME 
     , SALARY 
     , DEPARTMENT_ID 
  FROM EMPLOYEES E
 WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
   						  FROM DEPARTMENTS D
   						 WHERE D.MANAGER_ID = E.EMPLOYEE_ID )
;

SELECT E.FIRST_NAME 
     , E.SALARY 
     , E.DEPARTMENT_ID 
  FROM EMPLOYEES E
 WHERE E.EMPLOYEE_ID  = (SELECT D.MANAGER_ID 
   						  FROM DEPARTMENTS D
   						 WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID )
;
 
-- Oracle Concat
-- 복수개의 컬럼을 하나의 컬럼으로 만들어주는것
-- 사원의 이름과 성을 한 컬럼으로 조회한다.
SELECT FIRST_NAME ||' '|| LAST_NAME AS NAME
  FROM EMPLOYEES 
;
-- 사원의 이름, 사원이 근무중인 부서의 이름, 부서장 사원 번호를 한 컬럼으로 조회한다.
SELECT E.FIRST_NAME ||' '|| D.DEPARTMENT_NAME || ' '|| D.MANAGER_ID 
  FROM EMPLOYEES E 
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID  = D.DEPARTMENT_ID 
;
  
-- 사원의 이름, 사원이 근무중인 부서의 이름과 부서장 사원의 이름을 한 컬럼으로 조회한다. 
SELECT E.FIRST_NAME ||' '|| D.DEPARTMENT_NAME || ' ' || D_MAN.FIRST_NAME
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 INNER JOIN EMPLOYEES D_MAN
    ON D_MAN.EMPLOYEE_ID  = D.MANAGER_ID 
;

SELECT E.FIRST_NAME 
     , (SELECT D.DEPARTMENT_NAME 
          FROM DEPARTMENTS D
         WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID )
     , (SELECT D_MAN.FIRST_NAME
          FROM DEPARTMENTS D
         INNER JOIN EMPLOYEES D_MAN
         	ON D.MANAGER_ID  = D_MAN.EMPLOYEE_ID 
         WHERE D.DEPARTMENT_ID = E)
     
  FROM EMPLOYEES E


-- [DENSE_]RANK() OVER(), ROW_NUMBER() OVER() 없이 조회.
-- 사원 중 작은 급여를 받는 10명을 조회한다.
-- 인라인뷰가 아닌 1단계에서 ROWNUM을 사용할 경우 ORDER BY 기준으로 순번이 아닌 기존 데이터가 저장되어있는 순번대로 번호를 순서를 정해줌
SELECT FIRST_NAME
     , SALARY 
  FROM EMPLOYEES
 ORDER BY SALARY ASC
;

SELECT FIRST_NAME 
	 , SALARY 
--	 , ROWNUM
  FROM (SELECT FIRST_NAME
    		 , SALARY 
  		  FROM EMPLOYEES
		 ORDER BY SALARY ASC)
 WHERE ROWNUM <= 10
;
-- 사원 중 많은 급여를 받는 10명을 조회한다.
-- 사원들이 받는 급여 높은급여순으로
SELECT FIRST_NAME 
     , SALARY 
  FROM EMPLOYEES
 ORDER BY SALARY DESC
;

SELECT FIRST_NAME 
	 , SALARY 
	 , ROWNUM
  FROM (SELECT FIRST_NAME 
		     , SALARY 
		  FROM EMPLOYEES
		 ORDER BY SALARY DESC)
 WHERE ROWNUM <= 10
;
-- 많은 급여를 받는 중 5 ~ 9 번째 사원을 조회한다.   
SELECT FIRST_NAME 
	 , SALARY 
	 , ROWNUM
  FROM (SELECT FIRST_NAME 
		     , SALARY 
		  FROM EMPLOYEES
		 ORDER BY SALARY DESC)
 WHERE ROWNUM <= 9
   AND ROWNUM >= 5
;

SELECT FIRST_NAME 
	 , SALARY 
	 , ROWNUM AS RNUM
  FROM (SELECT FIRST_NAME 
		     , SALARY 
		  FROM EMPLOYEES
		 ORDER BY SALARY DESC)
 WHERE ROWNUM <= 9
;

SELECT FIRST_NAME
     , SALARY
  FROM (SELECT FIRST_NAME 
			 , SALARY 
			 , ROWNUM AS RNUM
		  FROM (SELECT FIRST_NAME 
				     , SALARY 
				  FROM EMPLOYEES
				 ORDER BY SALARY DESC)
		 WHERE ROWNUM <= 9)
 WHERE RNUM >= 5
;

-- 부서 정보(정렬없음) 중 6번째 부터 12번재 까지의 부서의 이름을 조회한다.
SELECT DEPARTMENT_NAME
	 , ROWNUM AS RNUM
  FROM DEPARTMENTS 
 WHERE ROWNUM <= 12
;

SELECT DEPARTMENT_NAME
  FROM (SELECT DEPARTMENT_NAME
			 , ROWNUM AS RNUM
		  FROM DEPARTMENTS 
		 WHERE ROWNUM <= 12)
 WHERE RNUM >= 6
;

SELECT *
  FROM EMPLOYEES 
;

-- 부서장이 있는 부서를 부서명으로 오름차순 정렬한 결과에서 2번째 부터 7번째까지 부서명만 조회한다.
--부서와 부서장
SELECT DEPARTMENT_NAME 
  FROM DEPARTMENTS 
 WHERE MANAGER_ID IS NOT NULL 
 ORDER BY DEPARTMENT_NAME  ASC  
;

SELECT DEPARTMENT_NAME
     , ROWNUM AS RNUM
  FROM (SELECT DEPARTMENT_NAME 
		  FROM DEPARTMENTS 
		 WHERE MANAGER_ID IS NOT NULL 
		 ORDER BY DEPARTMENT_NAME  ASC  )
 WHERE ROWNUM <= 7
;

SELECT DEPARTMENT_NAME
  FROM (SELECT DEPARTMENT_NAME
		     , ROWNUM AS RNUM
		  FROM (SELECT DEPARTMENT_NAME 
				  FROM DEPARTMENTS 
				 WHERE MANAGER_ID IS NOT NULL 
				 ORDER BY DEPARTMENT_NAME  ASC  )
		 WHERE ROWNUM <= 7)
 WHERE RNUM >= 2
;

-- 커미션을 포함한 급여순으로 사원들을 내림차순 정렬하고 그 중 7번째 ~ 16번째 까지의 사원 이름과 급여를 조회한다.
-- 커미션을 포함한 급여 ROWNUM 정렬이 필요없을때 물론 정렬이 필요해도 써도 됨
SELECT FIRST_NAME 
	 , SALARY + (SALARY * NVL(COMMISSION_PCT,0) ) AS TOTAL_SALARY
  FROM EMPLOYEES
 ORDER BY TOTAL_SALARY DESC
;

SELECT FIRST_NAME
     , TOTAL_SALARY
     , ROWNUM AS RNUM
  FROM (SELECT FIRST_NAME 
			 , SALARY + (SALARY * NVL(COMMISSION_PCT,0) ) AS TOTAL_SALARY
		  FROM EMPLOYEES
		 ORDER BY TOTAL_SALARY DESC)
 WHERE ROWNUM <= 16
;

SELECT FIRST_NAME
     , TOTAL_SALARY
     , RNUM 
  FROM (SELECT FIRST_NAME
		     , TOTAL_SALARY
		     , ROWNUM AS RNUM
		  FROM (SELECT FIRST_NAME 
					 , SALARY + (SALARY * NVL(COMMISSION_PCT,0) ) AS TOTAL_SALARY
				  FROM EMPLOYEES
				 ORDER BY TOTAL_SALARY DESC)
		 WHERE ROWNUM <= 16)
 WHERE RNUM >= 7
;
-- 커미션을 포함한 급여 ROW_NUMBER() OVER() 정렬이 필요할때 
SELECT FIRST_NAME 
	 , SALARY + (SALARY * NVL(COMMISSION_PCT,0) ) AS TOTAL_SALARY
  FROM EMPLOYEES
;

SELECT FIRST_NAME
     , TOTAL_SALARY
     , ROW_NUMBER() OVER (ORDER BY TOTAL_SALARY DESC) AS RANK
  FROM (SELECT FIRST_NAME 
			 , SALARY + (SALARY * NVL(COMMISSION_PCT,0) ) AS TOTAL_SALARY
		  FROM EMPLOYEES)
;

SELECT FIRST_NAME 
     , TOTAL_SALARY 
     , RANK
  FROM(SELECT FIRST_NAME
	        , TOTAL_SALARY
	        , ROW_NUMBER() OVER (ORDER BY TOTAL_SALARY DESC) AS RANK
	     FROM (SELECT FIRST_NAME 
				    , SALARY + (SALARY * NVL(COMMISSION_PCT,0) ) AS TOTAL_SALARY
			     FROM EMPLOYEES))
 WHERE RANK >= 7
   AND RANK <= 16
;

-- Row 순위 구하기
-- RANK() OVER() - ANSI
-- 공동 1등, 3명 2등 2명, 3등 3명, 4등 1명 --> 1 1 1 4 4 6 6 6 
SELECT SALARY
     , RANK() OVER( ORDER BY SALARY DESC) AS RANK
  FROM EMPLOYEES
;
-- DENSRANK - ANSI
-- 공동 1등, 3명 2등 2명, 3등 3명, 4등 1명 --> 1 1 1 2 2 3 3 3
SELECT SALARY
     , DENSE_RANK() OVER( ORDER BY SALARY DESC) AS RANK
  FROM EMPLOYEES
;
-- ROW_NUMBER() OVER() -ANSI
SELECT SALARY
     , ROW_NUMBER() OVER( ORDER BY SALARY DESC) AS RANK
  FROM EMPLOYEES
;

-- ROWNUM - ANSI X
-- 	공동1등 3명, 2등 1명, 3등 3명, 4등 1명 --> 1 2 3 4 5 6 7 8 9

-- 70, 80, 90, 100번 부서에서 근무중인 사원의 이름과 부서명을 조회한다.
SELECT E.FIRST_NAME 
     , D.DEPARTMENT_NAME 
  FROM EMPLOYEES E -- 100억번
 INNER JOIN DEPARTMENTS D -- 10억번
    ON E.DEPARTMENT_ID  = D.DEPARTMENT_ID 
 WHERE D.DEPARTMENT_ID  IN (70, 80, 90, 100) -- 100건
 ORDER BY D.DEPARTMENT_ID 
;
-- 10억번을 100억번 반복해서 비교하겠다
-- INLINE VIEW를 이용한 성능 향상
SELECT E.FIRST_NAME 
     , D.DEPARTMENT_NAME 
  FROM (SELECT FIRST_NAME 
             , DEPARTMENT_ID 
          FROM EMPLOYEES
         WHERE DEPARTMENT_ID IN (70,80,90,100)) E  -- 100건
 INNER JOIN DEPARTMENTS D -- 10억번
    ON E.DEPARTMENT_ID  = D.DEPARTMENT_ID 
 ORDER BY D.DEPARTMENT_ID 
;
-- INLINE VIEW를 이용한 성능 향상 2
SELECT E.FIRST_NAME 
     , D.DEPARTMENT_NAME 
  FROM (SELECT FIRST_NAME 
             , DEPARTMENT_ID 
          FROM EMPLOYEES
         WHERE DEPARTMENT_ID IN (70,80,90,100)) E 
 INNER JOIN (SELECT DEPARTMENT_ID 
                  , DEPARTMENT_NAME 
 			   FROM DEPARTMENTS
 			  WHERE DEPARTMENT_ID IN (70, 80, 90, 100)) D
    ON E.DEPARTMENT_ID  = D.DEPARTMENT_ID 
 ORDER BY D.DEPARTMENT_ID 
;

-- 입사 연도별 최고 급여를 조회한다.
SELECT TO_CHAR(HIRE_DATE, 'YYYY')
     , MAX(SALARY )
  FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE, 'YYYY') 
;
-- INLINE VIEW를 이용한 성능 향상
SELECT SALARY
     , TO_CHAR(HIRE_DATE, 'YYYY') AS HIRE_YEAR
  FROM EMPLOYEES
;

SELECT HIRE_YEAR 
	 , MAX(SALARY )
  FROM(SELECT SALARY
    	    , TO_CHAR(HIRE_DATE, 'YYYY') AS HIRE_YEAR
  		 FROM EMPLOYEES)
 GROUP BY HIRE_YEAR 
 ORDER BY HIRE_YEAR 
;

-- 입사 연도별 사원의 수를 조회한다.
SELECT HIRE_DATE 
     , COUNT(EMPLOYEE_ID )
  FROM EMPLOYEES
 GROUP BY HIRE_DATE 
;

-- INLINE VIEW를 이용한 성능 향상
SELECT EMPLOYEE_ID 
     , TO_CHAR(HIRE_DATE , 'YYYY') AS HIRE_YEAR
  FROM EMPLOYEES
;

SELECT HIRE_YEAR 
     , COUNT(EMPLOYEE_ID )
  FROM (SELECT EMPLOYEE_ID 
    		 , TO_CHAR(HIRE_DATE , 'YYYY') AS HIRE_YEAR
  		  FROM EMPLOYEES)
 GROUP BY HIRE_YEAR 
 ORDER BY HIRE_YEAR 
;

-- 사원의 이름의 첫 번재 글자만 가져온다.
SELECT FIRST_NAME
     , SUBSTR(FIRST_NAME, 1, 1)
  FROM EMPLOYEES
;

-- 사원 이름의 첫 번째 글자별 급여 합계를 조회한다.
SELECT SUBSTR(FIRST_NAME, 1, 1)
     , SUM(SALARY )
  FROM EMPLOYEES
 GROUP BY SUBSTR(FIRST_NAME, 1, 1)
;
-- INLINE VIEW를 이용한 성능향상
SELECT FIRST_LETTER 
     , SUM(SALARY )
  FROM (SELECT SALARY 
  			 , SUBSTR(FIRST_NAME, 1, 1) AS FIRST_LETTER
          FROM EMPLOYEES)
 GROUP BY FIRST_LETTER
 ORDER BY FIRST_LETTER
;




SELECT *
  FROM EMP_DETAILS_VIEW
;

-- ERD
--테이블 조인 + 그룹핑
-- 직무명 별 수행중인 사원의 수를 조회한다.
SELECT J.JOB_TITLE 
     , COUNT(E.EMPLOYEE_ID)
  FROM EMPLOYEES E
 INNER JOIN JOBS J
    ON E.JOB_ID  = J.JOB_ID 
 GROUP BY J.JOB_TITLE
;
-- 직무명 별 수행중인 사원의 수를 조회한다. 직무명으로 오름차순 정렬
SELECT J.JOB_TITLE 
     , COUNT(E.EMPLOYEE_ID)
  FROM EMPLOYEES E
 INNER JOIN JOBS J
    ON E.JOB_ID  = J.JOB_ID 
 GROUP BY J.JOB_TITLE
 ORDER BY J.JOB_TITLE ASC
;

-- 직무명 별 수행중인 사원의 수를 조회한다. 사원의 수로 내림차순 정렬
SELECT J.JOB_TITLE 
     , COUNT(E.EMPLOYEE_ID) AS EMP_CNT
  FROM EMPLOYEES E
 INNER JOIN JOBS J
    ON E.JOB_ID  = J.JOB_ID 
 GROUP BY J.JOB_TITLE
 ORDER BY EMP_CNT DESC
;



--테이블 조인 + 조건
-- 아래로 내려갈 수 록 찾는 속도가 빨라짐
-- 108번 사원의 이름과 부서명을 조회한다.
SELECT E.FIRST_NAME 
     , D.DEPARTMENT_ID 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID  = D.DEPARTMENT_ID 
 WHERE E.EMPLOYEE_ID = 108
;

-- 108번 사원의 이름과 부서명을 조회한다.(조인 최적화)
SELECT E.FIRST_NAME 
     , D.DEPARTMENT_NAME 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID =D.DEPARTMENT_ID 
   AND E.EMPLOYEE_ID = 108
;

-- 108번 사원의 이름과 부서명을 조회한다.
SELECT E.FIRST_NAME 
     , D.DEPARTMENT_ID 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.EMPLOYEE_ID = 108
 WHERE E.DEPARTMENT_ID  = D.DEPARTMENT_ID 
;

-- 직무의 아이디가 AD_VP이거나 부서의 번호가 70번인 사원의 이름, 직무명, 부서번호를 조회한다.
SELECT E.FIRST_NAME
     , J.JOB_TITLE 
     , D.DEPARTMENT_NAME 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 INNER JOIN JOBS J
    ON E.JOB_ID  = J.JOB_ID 
 WHERE J.JOB_ID = 'AD_VP'
    OR D.DEPARTMENT_ID = 70
;

-- 직무명이 'Administration Vice President'이거나 부서의 번호가 70번인 사원의 이름, 부서명를 조회한다.
SELECT JOB_ID 
  FROM JOBS
 WHERE JOB_TITLE = 'Administration Vice President'
;

SELECT E.FIRST_NAME  
     , D.DEPARTMENT_NAME 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 WHERE D.DEPARTMENT_ID = 70
    OR E.JOB_ID  = (SELECT JOB_ID 
 					  FROM JOBS
  					 WHERE JOB_TITLE = 'Administration Vice President')
;

-- 'Europe' 모든 사원의 이름과 근무중인 도시를 조회한다
SELECT *
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 INNER JOIN LOCATIONS L
    ON D.LOCATION_ID = L.LOCATION_ID 
 WHERE L.COUNTRY_ID IN EUROPE에 존재하는 국가의 아이디들
;


-- EUROPE
SELECT REGION_ID 
  FROM REGIONS
 WHERE REGION_NAME = 'Europe'
;
-- Europe에 존재하는 국가의 아이디들
SELECT COUNTRY_ID 
  FROM COUNTRIES
 WHERE REGION_ID = (SELECT REGION_ID 
 					  FROM REGIONS
					 WHERE REGION_NAME = 'Europe')	
;

SELECT E.FIRST_NAME 
     , L.CITY 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 INNER JOIN LOCATIONS L
    ON D.LOCATION_ID = L.LOCATION_ID 
 WHERE L.COUNTRY_ID IN (SELECT COUNTRY_ID 
 						  FROM COUNTRIES
 						 WHERE REGION_ID = (SELECT REGION_ID 
 					 						   FROM REGIONS
											  WHERE REGION_NAME = 'Europe'))
;


-- 테이블 조인(여러 테이블을 관계를 이용해 하나의 테이블로 만드는 과정) 연습
-- 직무가 변경된 사원들의 사원번호, 이름, 급여, 현재 수행중인 직무의 이름, 과거에 근무했던 부서의 이름, 현재 근무중인 부서의 이름을 조회한다.
SELECT JH.EMPLOYEE_ID 
     , E.FIRST_NAME 
     , E.LAST_NAME 
     , E.SALARY 
     , J_PRESENT.JOB_TITLE 
     , D_PAST.DEPARTMENT_NAME 
     , D_PRESENT.DEPARTMENT_NAME 
  FROM EMPLOYEES E
 INNER JOIN JOBS J_PRESENT -- 현재 수행중인 직무 이름
    ON E.JOB_ID  = J_PRESENT.JOB_ID 
 INNER JOIN JOB_HISTORY JH --직무가 변경된 사원의 사원번호
    ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID 
 INNER JOIN DEPARTMENTS D_PAST -- 과거에 근무했던 부서의 이름
    ON JH.DEPARTMENT_ID = D_PAST.DEPARTMENT_ID 
 INNER JOIN DEPARTMENTS D_PRESENT -- 현재 근무중인 부서의 이름
    ON D_PRESENT.DEPARTMENT_ID = E.DEPARTMENT_ID
;

-- 3개 이상의 테이블 조인 방법
-- 사원 부서 직무
SELECT *
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D -- 사원 + 부서
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 INNER JOIN JOBS J -- 사원 + 직무
    ON E.JOB_ID = J.JOB_ID 
;

--사원 + 부서 + 직무 + 지역
SELECT *
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D -- 사원 + 부서
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 INNER JOIN JOBS J -- 사원 + 직무
    ON E.JOB_ID = J.JOB_ID 
 INNER JOIN LOCATIONS L -- 부서 + 지역
    ON D.LOCATION_ID = L.LOCATION_ID 
;

-- 사원 + 부서 + 지역 + 국가 + 대륙
SELECT *
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D -- 사원 + 부서
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
 INNER JOIN LOCATIONS L -- 부서 + 지역
    ON D.LOCATION_ID  = L.LOCATION_ID 
 INNER JOIN COUNTRIES C -- 지역 + 국가
    ON C.COUNTRY_ID = L.COUNTRY_ID 
 INNER JOIN REGIONS R
    ON R.REGION_ID = C.REGION_ID 
;


-- 사원 테이블 + 부서 테이블 ==> 사원_부서
-- 사원의 이름, 성, 급여, 부서장의 사원번호, 부서명
SELECT E.FIRST_NAME 
     , E.LAST_NAME 
     , E.SALARY 
     , D.MANAGER_ID
     , D.DEPARTMENT_NAME 
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
;

-- 사원의 이름과 성, 직무아이디, 직무의 이름, 급여, 최대 급여, 최소 급여를 조회한다.
-- EMPLOYEES, JOBS
SELECT E.FIRST_NAME 
     , E.LAST_NAME 
     , J.JOB_ID 
     , J.JOB_TITLE 
     , E.SALARY 
     , J.MAX_SALARY 
     , J.MIN_SALARY 
  FROM EMPLOYEES E
 INNER JOIN JOBS J
    ON E.JOB_ID  = J.JOB_ID 
;
  


-- 80번 부서의 부서장으로 근무하는 사원의 직무명을 조회한다.
-- 1.80번 부서의 부서장 사원번호 145
SELECT MANAGER_ID 
  FROM DEPARTMENTS
 WHERE DEPARTMENT_ID = 80
;
-- 2. 부서장의 사원번호로 직무 아이디 조회
SELECT JOB_ID 
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = (SELECT MANAGER_ID 
  					    FROM DEPARTMENTS
 					   WHERE DEPARTMENT_ID = 80)
;
-- 3. 직무 아이디로 직무명
SELECT JOB_TITLE 
  FROM JOBS
 WHERE JOB_ID = (SELECT JOB_ID 
  				   FROM EMPLOYEES
				  WHERE EMPLOYEE_ID = (SELECT MANAGER_ID 
				  					     FROM DEPARTMENTS
				 					    WHERE DEPARTMENT_ID = 80))
;

--103번 사원이 근무중인 부서의 이름을 조회한다.
--1.
SELECT DEPARTMENT_NAME 
  FROM DEPARTMENTS 
 WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
 						  FROM EMPLOYEES
 						 WHERE EMPLOYEE_ID = 103)
;

--118번의 사원이 근무중이 부서의 도시명을 조회한다.
--1. 사원으로 부서번호 30
SELECT DEPARTMENT_ID 
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 118
;

-- 2. 30 부서번호로 지역번호 1700
SELECT LOCATION_ID 
  FROM DEPARTMENTS 
 WHERE DEPARTMENT_ID = 30
;

-- 3. 1700 지역번호로 도시명을 조회
SELECT CITY 
  FROM LOCATIONS 
 WHERE LOCATION_ID  = (SELECT LOCATION_ID 
 						 FROM DEPARTMENTS 
 						WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
 												 FROM EMPLOYEES
 												WHERE EMPLOYEE_ID = 118))
;

-- 'Seattle'에서 근무중인 사원들의 직무 명을 중복없이 조회한다.
-- 1. 'Seattle'의 지역번호 1700
SELECT LOCATION_ID 
  FROM LOCATIONS
 WHERE CITY = 'Seattle'
;

-- 2. 지역번호로 부서번호 10, 120 , ....
SELECT DEPARTMENT_ID 
  FROM DEPARTMENTS
 WHERE LOCATION_ID  = 1700
;

-- 3. 부서번호로 사원들의 직무아이디 조회
SELECT DISTINCT JOB_ID 
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID 
  						   FROM DEPARTMENTS
 						  WHERE LOCATION_ID  = 1700)
;

-- 4. 직무아이디로 직무명 
SELECT JOB_TITLE 
  FROM JOBS
 WHERE JOB_ID IN (SELECT DISTINCT JOB_ID 
  					FROM EMPLOYEES
				   WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID 
  						  					 FROM DEPARTMENTS
 						  					WHERE LOCATION_ID  = 1700))
;
-- 5. 합치기 
SELECT JOB_TITLE 
  FROM JOBS
 WHERE JOB_ID IN (SELECT DISTINCT JOB_ID 
  					FROM EMPLOYEES
				   WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID 
  						  					 FROM DEPARTMENTS
 						  					WHERE LOCATION_ID  = (SELECT LOCATION_ID 
  																	FROM LOCATIONS
 																   WHERE CITY = 'Seattle')))
;
--102번 사원이 수행중인 직무의 이름과 최대급여, 최소급여를 조회한다.
--1. 102번 사원의 직무 아이디
SELECT JOB_ID 
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 102
;

SELECT JOB_TITLE 
     , MAX_SALARY 
     , MIN_SALARY 
  FROM JOBS
 WHERE JOB_ID = (SELECT JOB_ID 
 				   FROM EMPLOYEES
 				  WHERE EMPLOYEE_ID = 102)
;
--Seattle에 있는 부서의 이름과 부서장의 사원 번호를 조회한다
--1.
SELECT LOCATION_ID 
  FROM LOCATIONS
 WHERE CITY = 'Seattle'
;

SELECT DEPARTMENT_NAME 
     , MANAGER_ID 
  FROM DEPARTMENTS
 WHERE LOCATION_ID = (SELECT LOCATION_ID 
                        FROM LOCATIONS
 					   WHERE CITY = 'Seattle')
;

--Asia에서 근무중인 사원들의 이름과, 성, 부서 번호를 조회한다.
--1. 아시아 3
SELECT REGION_ID  
  FROM REGIONS
 WHERE REGION_NAME = 'Asia'
;

--2.국가번호 AU CN IN JP ML SG
SELECT COUNTRY_ID 
  FROM COUNTRIES
 WHERE REGION_ID = (SELECT REGION_ID  
  					  FROM REGIONS
 					 WHERE REGION_NAME = 'Asia')
;

-- 3. 국가 아이디로 지역번호 조회
SELECT LOCATION_ID 
  FROM LOCATIONS
 WHERE COUNTRY_ID IN (SELECT COUNTRY_ID 
  						FROM COUNTRIES
 					   WHERE REGION_ID = (SELECT REGION_ID  
  					  						FROM REGIONS
 										   WHERE REGION_NAME = 'Asia'))	
;

-- 4. 지역번호로 부서번호 조회
SELECT DEPARTMENT_ID 
  FROM DEPARTMENTS 
 WHERE LOCATION_ID IN (SELECT LOCATION_ID 
  						 FROM LOCATIONS
 						WHERE COUNTRY_ID IN (SELECT COUNTRY_ID 
  											   FROM COUNTRIES
 					  						  WHERE REGION_ID = (SELECT REGION_ID  
						  					  					   FROM REGIONS
						 										  WHERE REGION_NAME = 'Asia')))
;

--5. 부서번호로 이름 성 부서번호 조회
SELECT FIRST_NAME 
     , LAST_NAME 
     , DEPARTMENT_ID 
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID 
						   FROM DEPARTMENTS 
						  WHERE LOCATION_ID IN (SELECT LOCATION_ID 
						  						  FROM LOCATIONS
						 						 WHERE COUNTRY_ID IN (SELECT COUNTRY_ID 
						  											    FROM COUNTRIES
						 					  						   WHERE REGION_ID = (SELECT REGION_ID  
												  					   					    FROM REGIONS
												 										   WHERE REGION_NAME = 'Asia'))))
;

-- 평균 급여보다 많은 급여를 받는 사원의 이름, 성, 급여를 조회한다.
-- 1. 특정할 수 없는 데이터가 무엇인가?
-- => 평균 급여
SELECT AVG(SALARY)
  FROM EMPLOYEES
;

-- 2. 특정할 수 없는 평균 급여를 무엇과 비교를 해야하는가?
SELECT FIRST_NAME 
     , LAST_NAME 
     , SALARY 
  FROM EMPLOYEES
 WHERE SALARY  > 6461.831775700934579439252336448598130841
;

SELECT FIRST_NAME 
     , LAST_NAME 
     , SALARY 
  FROM EMPLOYEES
 WHERE SALARY > (SELECT AVG(SALARY)
  				   FROM EMPLOYEES)
;

-- IT 부서에서 근무중인 사원들의 부서번호와 이름을 조회한다.
-- 1. 특정할 수 없는 것? => IT 부서의 부서번호 60
SELECT DEPARTMENT_ID 
  FROM DEPARTMENTS
 WHERE DEPARTMENT_NAME  = 'IT'
;
-- 2. 무엇과 비교를 해야하는가? => 사원이 근무중인 부서 
SELECT DEPARTMENT_ID 
     , FIRST_NAME 
  FROM  EMPLOYEES 
 WHERE DEPARTMENT_ID  = 60
;

--3. 하나로 합친다.
SELECT DEPARTMENT_ID 
     , FIRST_NAME 
  FROM  EMPLOYEES 
 WHERE DEPARTMENT_ID  = (SELECT DEPARTMENT_ID 
  						   FROM DEPARTMENTS
 						  WHERE DEPARTMENT_NAME  = 'IT')
;
 -- Marketing Representative 이름의 직무를 수행 중인 사원의 직무 아이디 급여를 조회한다.
-- 1. 특정할 수 없는것 ->Marketing Representative 이름의 직무 아이디
SELECT JOB_ID 
  FROM JOBS
 WHERE JOB_TITLE = 'Marketing Representative'
;
-- 2. 무엇과 비교를 해야하는가?
SELECT  JOB_ID 
  FROM EMPLOYEES
 WHERE JOB_ID = 'MK_REP'
;
-- 3. 하나로 합친다
SELECT JOB_ID 
  FROM EMPLOYEES
 WHERE JOB_ID = (SELECT JOB_ID 
                 FROM EMPLOYEES
                 WHERE JOB_ID = 'MK_REP')

-- 같은 급여을 받는 사원들은 몇명인지 급여별 사원의 수를 조회한다.
-- 이 때, 사원의 수가 1인 것은 제외한다.
SELECT SALARY 
	 , COUNT(EMPLOYEE_ID ) 
  FROM EMPLOYEES
 GROUP BY SALARY
HAVING COUNT(EMPLOYEE_ID )> 1 
 ORDER BY SALARY ASC
;

-- 같은 급여을 받는 사원들은 몇명인지 급여별 사원의 수를 조회한다.
SELECT SALARY 
	 , COUNT(EMPLOYEE_ID ) 
  FROM EMPLOYEES
 GROUP BY SALARY 
 ORDER BY SALARY ASC
;
-- 직무 아이디별 사원의 수, 급여의 총합, 평균 급여, 최고 급여, 최소 급여, 
--    가장 빠른 입사일, 가장 늦은 입사일을 조회한다.
SELECT JOB_ID 
     , COUNT(EMPLOYEE_ID )
     , SUM(SALARY)
     , AVG(SALARY )
     , MAX(SALARY )
     , MIN(SALARY )
     , MIN(HIRE_DATE )
     , MAX(HIRE_DATE )
  FROM EMPLOYEES
 GROUP BY JOB_ID 
;


-- 부서의 지역번호 별 부서의 개수를 조회한다.
SELECT LOCATION_ID 
     , COUNT(DEPARTMENT_ID )
  FROM DEPARTMENTS
 GROUP BY LOCATION_ID 
;
  

-- 지역의 국가아이디 별 지역의 개수를 조회한다.
SELECT COUNTRY_ID 
     , COUNT(LOCATION_ID )
  FROM LOCATIONS
 GROUP BY COUNTRY_ID 
;

-- 부서번호 별 사원의 수, 급여의 총합을 조회한다.
SELECT DEPARTMENT_ID 
     , COUNT(EMPLOYEE_ID )
     , SUM(SALARY )
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID 
;
-- 전체 사원들의 급여 총 합을 조회한다.
SELECT SUM(SALARY)
  FROM EMPLOYEES
;
-- 전체 사원 중 최저 급여를 조회한다.
SELECT MIN(SALARY)
  FROM EMPLOYEES
;
-- 전체 사원 중 최고 급여를 조회한다.
SELECT MAX(SALARY)
  FROM EMPLOYEES
;
-- 전체 사원의 평균 급여를 조회한다.
SELECT AVG(SALARY)
  FROM EMPLOYEES
;
-- 전체 사원 중 가장 일찍 입사한 날짜를 조회한다.
SELECT MIN(HIRE_DATE)
  FROM EMPLOYEES
;
-- 전체 사원 중 가장 늦게 입사한 날짜를 조회한다.
SELECT MAX(HIRE_DATE)
  FROM EMPLOYEES
;
-- 50번 부서에서 근무하는 사원들의 급여 총합을 조회한다.
SELECT SUM(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 50
;
-- 60번 부서에서 근무하는 사원들의 평균 급여를 조회한다.
SELECT AVG(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 60
;
-- 80번 부서에서 근무하는 사원들의 최고 급여를 조회한다.
SELECT MAX(SALARY )
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 80
;
-- 90번 부서에서 근무하는 사원들의 최저 급여를 조회한다.
SELECT MIN(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 90
;
-- 100번 부서에서 근무하는 사원들의 최고 급여, 최저 급여,
SELECT MAX(SALARY)
     , MIN(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 100
;
-- 가장 일찍 입사한 날짜(YYYY-MM-DD), 가장 늦게 입사한 날짜(YYYY-MM-DD), 평균 급여, 급여 총합을 조회한다.
SELECT TO_CHAR(MIN(HIRE_DATE), 'YYYY-MM-DD')
     , TO_CHAR(MAX(HIRE_DATE), 'YYYY-MM-DD')
     , AVG(SALARY)
     , SUM(SALARY)
  FROM EMPLOYEES
;
-- 전체 사원들의 최고 급여와 최저 급여의 차를 조회한다.
SELECT  MAX(SALARY) - MIN(SALARY)
  FROM EMPLOYEES
;

-- 전체 사원의 수를 조회한다.
SELECT COUNT(EMPLOYEE_ID )
  FROM EMPLOYEES
;
-- 70번 부서에서 근무 중인 사원의 수를 조회한다.
SELECT COUNT(EMPLOYEE_ID )
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 70
;

-- 이름이 'a'로 끝나는 사원의 이름과 성을 조회한다.
SELECT FIRST_NAME
     , LAST_NAME
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '%a'
;

-- 성이 'A'로 시작하는 사원의 이름과 성을 조회한다.
SELECT FIRST_NAME 
     , LAST_NAME 
  FROM EMPLOYEES 
 WHERE LAST_NAME LIKE 'A%'
;
-- 이름과 성에 'e'가 있는(포함되어있는) 사원의 이름과 성을 조회한다.
SELECT FIRST_NAME 
     , LAST_NAME 
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '%e%'
   AND LAST_NAME  LIKE '%e%'
;
-- 이름 또는 성에 'g'가 있는(포함되어있는) 사원의 이름과 성을 조회한다.
SELECT FIRST_NAME 
     , LAST_NAME 
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '%g%'
    OR LAST_NAME  LIKE '%g%'
;

-- 이름이 5자리인 사원의 이름과 성을 조회한다.
SELECT FIRST_NAME 
     , LAST_NAME 
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '_____'
;
-- 이름이 4자리 이상인 사원의 이름과 성을 조회한다.
SELECT FIRST_NAME 
     , LAST_NAME 
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '____%'
;
-- 성이 4자리 이상이며 다섯번째 자리의 글자가 'e'인 사원의 이름과 성을 조회한다.
 SELECT FIRST_NAME
      , LAST_NAME 
   FROM EMPLOYEES
  WHERE LAST_NAME LIKE '____%'
    AND FIRST_NAME LIKE '____e%'
 ;
-- 도시명이 'S'로 시작하는 도시의 이름을 조회한다.
SELECT  CITY 
  FROM LOCATIONS
 WHERE CITY LIKE 'S%'
;
-- 부서의 이름에 'r'이 있는(포함되어있는) 부서의 이름을 조회한다.
SELECT DEPARTMENT_NAME 
  FROM DEPARTMENTS
 WHERE DEPARTMENT_NAME LIKE '%r%'
;

-- 급여가 8000 이상이면서 커미션을 받는 사원의 급여, 커미션 비율을 조회한다.
SELECT SALARY
     , COMMISSION_PCT
  FROM EMPLOYEES
 WHERE SALARY >= 8000
   AND COMMISSION_PCT IS NOT NULL
;

-- 급여가 10000 이상이거나 커미션을 받는 사원의 급여, 커미션 비율을 조회한다.
SELECT SALARY 
     , COMMISSION_PCT 
  FROM EMPLOYEES
 WHERE SALARY >= 10000
    OR COMMISSION_PCT IS NOT NULL
;
-- 10번, 20번, 50번 부서번호에서 근무하는 모든 사원들의 근무부서 번호, 직무 아이디를 조회한다.
SELECT DEPARTMENT_ID 
     , JOB_ID 
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (10, 20, 50)
-- WHERE DEPARTMENT_ID = 10
--    OR DEPARTMENT_ID = 20
--    OR DEPARTMENT_ID = 50
;
-- 급여가 5000이상 10000미만이거나 직무아이디가 IT_PROG인 사원의 급여와 직무아이디를 조회한다.
SELECT SALARY
     , JOB_ID
  FROM EMPLOYEES
 WHERE SALARY BETWEEN 5000 AND 10000 -1 
    OR JOB_ID = 'IT_PROG'
;

-- 직무아이디가 IT_PROG, FI_ACCOUNT가 아닌 사원들의 직무 아이디를 중복없이 조회한다.
SELECT DISTINCT JOB_ID
  FROM EMPLOYEES
 WHERE JOB_ID NOT IN('IT_PROG', 'FI_ACCOUNT')
-- WHERE JOB_ID != 'IT_PROG'
--   AND JOB_ID != 'FI_ACCOUNT'
;

-- 급여가 2000 ~ 5000 사이 이거나 직무 아이디가 ST_MAN, SA_REP가 아닌 사원들의 급여와 직무아이디를 조회한다.
SELECT SALARY 
     , JOB_ID 
  FROM EMPLOYEES
 WHERE SALARY BETWEEN 2000 AND 5000
    OR JOB_ID NOT IN ('SA_REP', 'ST_MAN')
;

-- 상사사원번호가 101번 이거나 103번인 사원 중 급여가 5000 이상인 사원의 상사사원번호와 급여를 조회한다.
SELECT MANAGER_ID 
     , SALARY
  FROM EMPLOYEES
 WHERE MANAGER_ID IN (101, 103)
   AND SALARY >= 5000
-- WHERE (MANAGER_ID = 101 OR MANAGER_ID = 103)
--   AND SALARY >= 5000
;

-- 10, 20, 30, 40번 부서에서 근무하지 않는 사원들의 이름, 근무부서번호를 조회한다.
SELECT FIRST_NAME
     , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID NOT IN (10, 20, 30, 40)
;

-- 사원 번호가 108번인 사원의 사원번호, 이름, 성을 조회한다.
SELECT EMPLOYEE_ID 
     , FIRST_NAME 
     , LAST_NAME 
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 108
;

-- 이름이 'Steven'인 사원의 이름과 성, 급여, 근무부서번호를 조회한다.
SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
     , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE FIRST_NAME = 'Steven'
;

-- 근무부서 번호가 50인 사원의 이름, 성 상사사원번호, 직무 아이디를 조회한다.
-- 이 때, 상사사원번호로 내림차순 정렬한다.
SELECT FIRST_NAME
     , LAST_NAME
     , MANAGER_ID
     , JOB_ID
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 50
 ORDER BY MANAGER_ID DESC 
;

-- 도시의 이름이 'Seattle' 인 지역의 지역번호, 주소, 주, 국가아이디를 조회한다.
SELECT LOCATION_ID
     , STREET_ADDRESS
     , STATE_PROVINCE
     , COUNTRY_ID
  FROM LOCATIONS
 WHERE CITY = 'Seattle'
;

-- 101번 사원의 직무변경이력 중 직무 시작일, 직무 종료일, 직무 아이디, 근무 부서 아이디를 조회한다.
-- 이 때, 직무 시작일로 오름차순 정렬한다.
SELECT START_DATE
     , END_DATE
     , JOB_ID
     , DEPARTMENT_ID
  FROM JOB_HISTORY
 WHERE EMPLOYEE_ID = 101
 ORDER BY START_DATE ASC
;

-- 급여가 10000이상인 사원의 사원번호, 직무아이디, 급여, 근무부서 아이디를 조회한다.
-- 직무아이디 오름차순, 근무부서번호 오름차순, 급여 내림차순으로 정렬한다.
SELECT EMPLOYEE_ID 
     , JOB_ID
     , SALARY
     , DEPARTMENT_ID 
  FROM EMPLOYEES 
 WHERE SALARY >= 10000
 ORDER BY JOB_ID  ASC
     , DEPARTMENT_ID ASC
     , SALARY DESC
;
-- 커미션 비율이 0.2보다 작은 사원의 급여, 커미션 비율을 조회한다.
-- 급여 오름차순 정렬한다.
SELECT SALARY
     , COMMISSION_PCT
  FROM EMPLOYEES
 WHERE COMMISSION_PCT < 0.2
 ORDER BY SALARY ASC
;

--근무부서 번호가 50이 아닌 사원들의 부서번호, 직무아이디를 조회한다.
SELECT DEPARTMENT_ID
     , JOB_ID
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID != 50
;

-- 부서의 이름, 부서장의 번호, 지역의 번호를 조회한다.
-- 이 때, 부서장의 번호로 오름차순 정렬한다.
SELECT  DEPARTMENT_NAME
     , MANAGER_ID
     , LOCATION_ID
  FROM DEPARTMENTS
;

SELECT DEPARTMENT_NAME
     , MANAGER_ID
     , LOCATION_ID
  FROM DEPARTMENTS
  ORDER BY MANAGER_ID ASC
;

-- 부서의 지역번호를 중복없이 조회한다.
-- 이 때, 지역번호로 내림차순 정렬한다.
SELECT DISTINCT LOCATION_ID
  FROM DEPARTMENTS
  ORDER BY LOCATION_ID DESC 
;

-- 사원의 급여와 커미션 비율, 이름, 성을 조회한다.
-- 이때, 급여로 오름차순 정렬하고 같은 급여가 있을경우 커미션비율로 내림차순 정렬한다.
SELECT SALARY
     , COMMISSION_PCT
     , FIRST_NAME
     , LAST_NAME
  FROM EMPLOYEES
 ORDER BY SALARY ASC
     , COMMISSION_PCT DESC 
;

-- 모든 사원들의 이름, 성, 급여를 중복없이 조회한다.
SELECT FIRST_NAME 
     , LAST_NAME 
     , SALARY 
  FROM EMPLOYEES
;

SELECT DISTINCT FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
;

-- 모든 사원들의 급여와 커미션을 중복없이 조회한다.
SELECT DISTINCT SALARY
     , COMMISSION_PCT
  FROM EMPLOYEES
;

-- 현재 날짜와 시간을 "연-월-일 시:분:초" 형태로 보여준다.
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS')
     , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS')
  FROM DUAL
;

-- 현재 날짜와 시간을 보여준다.
SELECT SYSDATE
  FROM DUAL
;

-- 현재 날짜에서 하루를 더한 날짜와 시간을 보여준다.
SELECT SYSDATE + 1
  FROM DUAL
;

-- 현재 날짜에서 이틀을 더한 날짜와 시간을 보여준다.
SELECT SYSDATE + 2
  FROM DUAL
;

-- 현재 날짜에서 한달을 더한 날짜와 시간을 보여준다.
SELECT ADD_MONTHS(SYSDATE, 1) 
  FROM DUAL
;
-- 현재 날짜에서 한달을 뺀 날짜와 시간을 보여준다.
SELECT ADD_MONTHS(SYSDATE, -1)
  FROM DUAL
;

-- 현재 날짜에서 이틀을 뺀 날짜와 시간을 보여준다.
SELECT SYSDATE -2
  FROM DUAL
;

-- 현재 날짜에서 하루를 뺀 날짜와 시간을 보여준다.
SELECT SYSDATE -1
  FROM DUAL
;

-- 현재 날짜에서 1시간을 더한 날짜와 시간을 보여준다.
SELECT SYSDATE + 1/24 
  FROM DUAL
;

-- 현재 날짜에서 5시간을 더한 날짜와 시간을 보여준다.
SELECT SYSDATE + 5/24
  FROM DUAL
;

-- 현재 날짜에서 10시간을 더한 날짜와 시간을 보여준다.
SELECT SYSDATE + 10/24
  FROM DUAL
;

-- 현재 날짜에서 1분을 더한 날짜와 시간을 보여준다.
SELECT SYSDATE + 1/24/60
  FROM DUAL
;

-- 현재 날짜에서 13분을 더한 날짜와 시간을 보여준다.
SELECT SYSDATE + 1/24/60*13
  FROM DUAL
;

-- 현재 날짜에서 49초를 더한 날짜와 시간을 보여준다.
SELECT SYSDATE + 1/24/60/60*49
  FROM DUAL
;


SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , EMAIL
  FROM EMPLOYEES
;

-- DEPARTMENTS 테이블에서
-- DEPARTMENT_ID, MANAGER_ID만 조회해본다.
SELECT DEPARTMENT_ID
     , MANAGER_ID
  FROM DEPARTMENTS
;

-- COUNTRIES 테이블에서
-- COUNTRY_ID, COUNTRY_NAME, REGION_ID를 조회해본다.
SELECT COUNTRY_ID
     , COUNTRY_NAME
     , REGION_ID
  FROM COUNTRIES
;

SELECT *
  FROM COUNTRIES
;

-- 1. 사원의 이름과 성 그리고 급여를 조회한다.
SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
;

-- 2. 부서의 부서장 번호와 부서가 존재하는 지역의 번호를 조회한다.
SELECT MANAGER_ID
     , LOCATION_ID
  FROM DEPARTMENTS
;

-- 3. 국가의 아이디, 이름, 국가가 존재하는 대륙이 번호를 조회한다.
SELECT *
  FROM COUNTRIES
;

-- 4. 직무의 이름과 최대 급여를 조회한다.
SELECT JOB_TITLE
     , MAX_SALARY
  FROM JOBS
;
-- 5. 지역의 도시명 과 주소, 우편번호를 조회한다.
SELECT CITY
     , STREET_ADDRESS
     , POSTAL_CODE
  FROM LOCATIONS
;

-- 6. 사원의 상사사원번호와 입사일 그리고 연락처를 조회한다.
SELECT MANAGER_ID
     , HIRE_DATE
     , PHONE_NUMBER
  FROM EMPLOYEES
;

-- 7. 직무가 변경된 사원의 이전 직무 아이디, 이전 직무를 수행한 부서의 아이디,
--    이전 직무를 시작한 날짜를 조회한다.
SELECT JOB_ID
     , DEPARTMENT_ID
     , START_DATE
  FROM JOB_HISTORY
;

-- 8. 대륙의 아이디와 이름을 조회한다.
SELECT *
  FROM REGIONS
;
-- 9. 사원의 직무아이디와 부서번호만 조회한다.
SELECT JOB_ID
     , DEPARTMENT_ID
  FROM EMPLOYEES
;

-- 10. 사원의 이름, 성, 급여, 입사일, 부서의 이름, 부서장의 이름
--     지역의 도시명, 국가명, 대륙의 이름을 조회한다.
SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
     , HIRE_DATE
  FROM EMPLOYEES
;