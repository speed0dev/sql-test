# sql-test
sql test project

## SQL - query 

### sql 관련 util



### tablespace  확인

SELECT file_name, tablespace_name, autoextensible FROM DBA_DATA_FILES;


#### TEST DB  접속 정보

jdbc:oracle:thin:@[IP]:1521:xe

oracle.jdbc.OracleDriver

userId

password


### SQL 정리하기

SELECT * FROM (
    SELECT '1월' AS COL_MONTH FROM DUAL 
    UNION ALL
    SELECT '2월' AS COL_MONTH FROM DUAL 
    UNION ALL
    SELECT '3월' AS COL_MONTH FROM DUAL 
    UNION ALL
    SELECT '4월' AS COL_MONTH FROM DUAL 
    UNION ALL
    SELECT '5월' AS COL_MONTH FROM DUAL 
    UNION ALL
    SELECT '6월' AS COL_MONTH FROM DUAL 
) PIVOT(
    COUNT(*) FOR COL_MONTH IN ( '1월' AS MON1 , '2월' AS MON2, '3월' AS MON3, '4월' MON4 )
    )
