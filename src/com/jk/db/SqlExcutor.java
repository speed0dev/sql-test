package jk.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Enumeration;
import java.util.function.Function;

public class SqlExcutor {

//    private Function<T,R> sqlFun = null;
//    private Function<T,R> resultFunc = null;

    private SqlProcessor process;

    //
    public SqlExcutor(){

    }

//    public void setResult(Function<T,R> pFunc){
//        this.resultFunc = pFunc;
//
//    }

    public void setProcessSql(SqlProcessor p) {
        this.process = p;
        try {
            process.clear();
            this.sql();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //
    public void sql() throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData md = null;

        try {
            conn = DButil.getConnection();

            String sql = process.getSql();

            ps = conn.prepareStatement(sql);

            process.setParam(ps);

            rs = ps.executeQuery();
            while(rs.next()){

                // setHeader
                md = rs.getMetaData();
                process.callHeader(md);

                // excute
                process.callResult(rs);

            }
            rs.close();
            ps.close();
            conn.close();

        }catch(Exception e){
            throw e;
        }finally {
            if(rs!=null){rs.close();}
            if(ps!=null){ps.close();}
            if(conn!=null){conn.close();}
        }

    }



}
