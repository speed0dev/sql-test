package jk.db.entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ValueMapper {
    //저장순서 보장
    private Map<String,ValueItem> map = new LinkedHashMap<>();

    //private Map<String,ValueItem> map = new HashMap<>();

    public ValueMapper(){

    }

    public void add(String key, ValueItem item){
        map.put(key,item);
    }

    // 분리코드 값
    public String getValues(String sp){
        return "";
    };

    public Map<String,ValueItem> getMap() {
        return map;
    }

    //
    public String toDataInfo() {
        StringBuffer sb = new StringBuffer();
        map.forEach((key, value)->{
            sb.append( "{idx:" + value.getIdx() + " key:" + key + " value:" + value.getValue() + " type:" + value.getType() + "}");
        });
        return sb.toString();
    }
}
