package com.db;

import jk.db.MapperAnalizer;
import jk.db.SqlExcutor;
import jk.db.SqlProcessor;
import jk.db.entity.ValueMapper;
import jk.sql.CamelUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CDBInfoTest {

    @Test
    void calldbTableTest(){

        // to -> VO 만들기
        SqlProcessor p = new SqlProcessor();
        p.setSql("select * from EBKCON.IGIB_ACOM_COM_DTBANK  sample(10)");

        SqlExcutor sqlExe = new SqlExcutor();
        sqlExe.setProcessSql(p); //

        List<ValueMapper> r =  p.getResult();
        if(r!=null) {
            System.out.println(" size:" + r.size());
        }

        new MapperAnalizer(r).anlysis();

    }


    @Test
    void showText(){
        String name = "AAA_BBB_CCCcdEFgHXX_A";
        String rsult = CamelUtil.camelCase(name);
        System.out.println("@@ {" + rsult + "}");
        //

    }


}
