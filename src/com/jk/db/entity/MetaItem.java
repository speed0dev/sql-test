package jk.db.entity;

//
public class MetaItem {
    private String columName = "";
    private String columType = "";
    private int idx = 0;

    public MetaItem(int i, String cName, String typeName) {
        this.idx = i;
        this.columName = cName;
        this.columType = typeName;
        //
    }

    public String getColumName() {
        return columName;
    }

    public void setColumName(String columName) {
        this.columName = columName;
    }

    public String getColumType() {
        return columType;
    }

    public void setColumType(String columType) {
        this.columType = columType;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
}
