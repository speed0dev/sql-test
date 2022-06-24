package jk.db;

import jk.db.entity.MetaItem;
import jk.db.entity.ValueItem;
import jk.db.entity.ValueMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlProcessor {

    private String sql = "";

    private List<ValueItem> paramList = new ArrayList<>();
    private List<MetaItem> metaList = new ArrayList<>();

    private List<ValueMapper> resultList = null;

    public SqlProcessor(){
        clear();
    }

    //
    public void clear(){
        metaList.clear();
        paramList.clear();
        resultList = null;
    }


    public void setSql(String sql){
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    //------------------------------------------
    // setString(idx, )
    // setCharater(idx, )
    // setInt(idx, )
    // setLong(idx, )
    // setDouble(idx, )
    // setFloat(idx, )
    // setTime(idx, )
    public void setParam(PreparedStatement ps) throws SQLException {
        //
        ValueItem item = null;
        for(int i=0;i<paramList.size();i++){
            item = paramList.get(i);
            if("string".equals(item.getType())){
                ps.setString(i, (String)item.getValue());
            }else if("int".equals(item.getType())){
                ps.setInt(i, (int)item.getValue());
            }else if("long".equals(item.getType())){
                ps.setLong(i, (long)item.getValue());
            }else if("double".equals(item.getType())){
                ps.setDouble(i, (double)item.getValue());
            }else if("float".equals(item.getType())){
                ps.setFloat(i, (float)item.getValue());
            }else if("time".equals(item.getType())){
                ps.setTime(i, (Time)item.getValue());
            }
        }
    }

    public List<String> callHeader(ResultSetMetaData md) throws SQLException {
        List<String> calNameList = new ArrayList<>();
        if(md!=null) {

            for (int i = 1; i <= md.getColumnCount(); i++) {
                metaList.add(new MetaItem(i, md.getColumnName(i), md.getColumnTypeName(i)));
                calNameList.add(md.getColumnName(i));
            }
        }
        return calNameList;
    }

    public void callResult(ResultSet rs) throws SQLException {
        if(rs==null){
            return;
        }

        resultList = new ArrayList<>();
        ValueMapper mapper = null;
        MetaItem item = null;

        while(rs.next()) {
            mapper = new ValueMapper();
            for(int i=0;i<metaList.size();i++) {
                item = metaList.get(i);
                mapper.add( item.getColumName(), new ValueItem(i+1, item.getColumType(), item.getColumName() , rs.getObject(item.getColumName()) ) ); //
                //System.out.println(rs.getObject(nameList.get(i)));
            }
            resultList.add(mapper);
        }
    }

    //=====================================
    //
    public List<ValueMapper> getResult() {
        return resultList;
    }
}
