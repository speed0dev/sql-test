package jk.sql.data;

public class ParamUnit {
    String type = "";
    Object value = "";
    int idx = 0;

    public ParamUnit(int idx, String type, String value) {
        this.idx = idx;
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
}
