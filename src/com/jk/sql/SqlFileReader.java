package jk.sql;

import jk.sql.data.ParamUnit;
import jk.sql.data.SqlFileResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlFileReader {

    public SqlFileReader(){
        onInit();
    }

    private void onInit() {

        // functional 로 변경할것.
        //Function<String,File> fFileRead = this::fileRead;
        //Function<File,SqlFileResult> fReadSqlLines = this::readSqlLines;


    }

    //
    public void read(String fileName) throws Exception{
        // 1. fileRead
        // 2. sqlLine, paramLine
        // 3. sql, paramList
        // 4. makeSql
        // 5. result -> fileOut

        File f = fileRead(fileName);
        //fileRead_(fileName);
        SqlFileResult r = readSqlLines(f);
        List<ParamUnit> list = makeSqlParams(r);
        String sql = makeSql(list, r);
        resultOutput(sql);

    }

    private void resultOutput(String sql) {

        System.out.println(sql);
    }

    //
    private String makeSql(List<ParamUnit> list, SqlFileResult r) {
        String sql = r.getSqltxt();
        System.out.println(sql);
        for(ParamUnit u: list){
            System.out.println(">>>> " + u.getValue() + " " + u.getType());
            if("String".equals(u.getType())) {
                sql = sql.replaceFirst("\\?", "'" + (String)u.getValue() + "'");
            }else{
                sql = sql.replaceFirst("\\?",  "" + (String)u.getValue());
            }
        }
        return sql;

    }

    private List<ParamUnit> makeSqlParams(SqlFileResult r) {
        //System.out.println(r.getParamtxt());
        String paramTxt = r.getParamtxt();
        String[] paramUnit = paramTxt.split(",");
        List<ParamUnit> paramList = new ArrayList<>();
        int idx = 1;
        Pattern p1 = Pattern.compile("\\(.*\\)"); // \\
        Pattern p2 = Pattern.compile(".*\\(");

        String type = "";
        String value = "";
        for(String unit: paramUnit){
            type = "";
            value = "";
            Matcher m1 = p1.matcher(unit); //
            if(m1.find()){
                //System.out.println("###m1  " + m1.group());
                type = m1.group().trim();
                type = type.replace("(", "");
                type = type.replace(")", "");
            }
            Matcher m2 = p2.matcher(unit);
            if(m2.find()){
                //System.out.println("###m2  " + m2.group());
                value = m2.group().trim();
                value = value.replace("(", "");
            }

            if(!"".equals(type) && !"".equals(value) ) {
                System.out.println(type + " " + value + idx);
                paramList.add(new ParamUnit(idx, type, value));
                ++idx;
            }
        }
        return paramList;
    }

    //
    private File fileRead(String fileName){
        File f = new File(fileName);
        if(!f.exists()){
            //throw new Exception("file not found!");

        }
        return f;
    }

    private SqlFileResult readSqlLines(File f) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
        String line = "";
        try {
            String queryLine = "";
            String paramLine = "";
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                if(line.contains("Preparing:")){
                    String[] tmp = line.split("Preparing:");
                    queryLine = tmp[1];
                }else if(line.contains("Parameters:")){
                    String[] tmp = line.split("Parameters:");
                    paramLine = tmp[1];
                }
            }
            SqlFileResult result = new SqlFileResult(queryLine, paramLine);
            return result;
        }finally {
            if(br!=null) {
                br.close();
            }
        }


    }


}
