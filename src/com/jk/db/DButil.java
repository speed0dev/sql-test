package jk.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {

//    private final static String driverName = "oracle.jdbc.driver.OracleDriver";
//    private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
//    private final static String user = "devuser2";
//    private final static String password = "dev000";

    private final static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@192.168.88.197:13042:DBLNID5";
    private static String user = "ebkcon";
    private static String password = "ebkdbcon";

    public static void config(String url1, String user1, String password1){
        url = url1;
        user = user1;
        password = password1;
    }

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
