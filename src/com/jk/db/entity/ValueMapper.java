package jk.db.entity;

import java.util.HashMap;
import java.util.Map;

public class ValueMapper {
    private Map<String,ValueItem> map = new HashMap<>();

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
            sb.append( value.getIdx() + " " + key + " " + value.getValue() + " ");
        });
        return sb.toString();
    }
}
