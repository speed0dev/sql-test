package jk.db.entity;

public class ValueItem {
    private int idx = 0;

    private String type;    // class type
    private String name;
    private Object value;


    public ValueItem(int i, String type, String name, Object v) {
        this.idx = i;
        this.name = name;
        this.value = v;
        this.type = type;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo(){
        return name + ":" + value;
    }
}
