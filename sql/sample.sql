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
    
    ;


[]
  SELECT 
        -- c.*, 
         t.COLUMN_NAME
        , t.DATA_TYPE
        , c.COMMENTS
    FROM  user_col_comments c , all_tab_columns t
    where 1=1
    AND c.table_name = t.table_name
    AND c.column_name = t.COLUMN_NAME
    AND c.table_name='TB_SAMPLE'
    
  ;
