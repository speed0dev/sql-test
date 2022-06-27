package jk.sql.data;

public class SqlFileResult {
    String sqltxt;
    String paramtxt;

    public SqlFileResult(String sql, String param) {
        this.sqltxt = sql;
        this.paramtxt = param;
    }

    public String getSqltxt() {
        return sqltxt;
    }

    public void setSqltxt(String sqltxt) {
        this.sqltxt = sqltxt;
    }

    public String getParamtxt() {
        return paramtxt;
    }

    public void setParamtxt(String paramtxt) {
        this.paramtxt = paramtxt;
    }
}
