package com.db;

import jk.db.DButil;
import jk.db.MapperAnalizer;
import jk.db.SqlExcutor;
import jk.db.SqlProcessor;
import jk.db.entity.ValueMapper;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

public class DBTest {

    @Test
    void dbTest(){
        //
        try {
            //
            Connection conn = DButil.getConnection();
            System.out.println(" @ conn:" + conn);

        }catch (Exception e){

        }

    }

    //
    @Test
    void sqlTest(){
        try {

            //
            SqlProcessor p = new SqlProcessor();
            p.setSql("select * from TB_MEMBER");

            SqlExcutor sqlExe = new SqlExcutor();
            sqlExe.setProcessSql(p); //

            List<ValueMapper> r =  p.getResult();
            System.out.println(" size:" + r.size());

            new MapperAnalizer(r).anlysis();



        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
