package jk.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {

    private final static String driverName = "oracle.jdbc.driver.OracleDriver";
    private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final static String user = "devuser2";
    private final static String password = "dev000";

    //
    public static Connection getConnection() throws Exception{

        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);

        }catch(Exception e){
            e.printStackTrace();;
            throw e;
        }
        return conn;
    }


}
