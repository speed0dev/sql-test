package jk.db;

import jk.db.entity.ValueMapper;

import java.util.List;

public class MapperAnalizer {

    List<ValueMapper> rList = null;

    public MapperAnalizer(List<ValueMapper> r){
        rList = r;
    }

    //
    public void anlysis() {

        for(ValueMapper m: rList){
            System.out.println(m.toDataInfo()); //
        }
        //
    }
}
