AAA mapper.DataInfoMapper.insertDataInfo] ==>  Preparing: INSERT /* 한글처리 입니다. */ INTO tb_datainfo ( sys_id ,sys_name ,sys_info ,sys_ver ,use_yn ,pow ,create_dt ,update_dt ) VALUES ( ? ,? ,? ,? ,? ,? ,CURRENT_DATE ,CURRENT_DATE )
2022-06-27 17:12:29,006 DEBUG [egovframework.example.sys.data.mapper.DataInfoMapper.insertDataInfo] ==> Parameters: ID-11(String), 테스트시스템B(String), INFO(String), 1.0ver(String), Y(String), 29.11(Double)
2022-06-27 17:12:29,008 DEBUG [egovframework.example.sys.data.mapper.DataInfoMapper.insertDataInfo] <==    Updates: 1