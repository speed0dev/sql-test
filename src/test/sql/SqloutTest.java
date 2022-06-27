package sql;


import jk.sql.SqlFileReader;
import org.junit.jupiter.api.Test;

public class SqloutTest {

    @Test
    void sqloutTest(){
        String fname = "D:/JavaBaseProjects/dataConvert/temps/sqlSample/runSql.sql";
        SqlFileReader s = new SqlFileReader();
        try {
            s.read(fname);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
