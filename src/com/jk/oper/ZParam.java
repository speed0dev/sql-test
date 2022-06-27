package jk.oper;

import java.util.List;

public class ZParam <T>{
    T obj;
    List<T> list;
    String name;
    String type;

    public ZParam(T o){
        this.obj = o;
    }
    public void set(T o){
        this.obj = o;
    }

    public T get(){
        return obj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
