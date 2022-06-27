package jk.oper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CFComponent {

    // 사용법 - 확장하기
    List<Function<ZPairParam,ZPairParam>> fList = null;

    //
    Map<String,Function<ZPairParam,ZPairParam>> mapper = new HashMap<>();

    private boolean bLog = true;

    public CFComponent(){
        onInit();
    }

    private void onInit() {
        mapper.put("init", (param)->{
            if(bLog) {
                System.out.println("[init]");
            }
            return param;
        });
        mapper.put("setting", (p)->{
            if(bLog) {
                System.out.println("[setting]");
            }
            return p;
        });
        mapper.put("execute", (p)->{
            if(bLog) {
                System.out.println("[execute]");
            }
            return p;
        });
        mapper.put("result", (p)->{
            if(bLog) {
                System.out.println("[result]");
            }
            return p;
        });
        mapper.put("dispose", (p)->{
            if(bLog) {
                System.out.println("[dispose]");
            }
            return p;
        });
    }

    //
    public void setFunc(String key, Function<ZPairParam,ZPairParam> pF){
        if(mapper.containsKey(key)){
            mapper.put(key, pF);
        }
    }

    //
    public void setFList(Function<ZPairParam,ZPairParam>... ff){
        fList = Arrays.asList(ff);
    }

    public<T,R> Object[] execute(T in, R out){

        // [makeFunction]
        // init
        // setting
        // execute
        // result
        // dispose
        Function<ZPairParam,ZPairParam> init = mapper.get("init");
        Function<ZPairParam,ZPairParam> setting = mapper.get("setting");
        Function<ZPairParam,ZPairParam> execute = mapper.get("execute");
        Function<ZPairParam,ZPairParam> result = mapper.get("result");
        Function<ZPairParam,ZPairParam> dispose = mapper.get("dispose");

        // method adds
        Function<ZPairParam,ZPairParam> fLinked = init.andThen(setting.andThen(execute.andThen(result.andThen(dispose))));

        //
        ZPairParam<T,R> inParam = new ZPairParam<>(in,out);

        ZPairParam<T,R> resultParam = fLinked.apply(inParam);

//        Object[] rr = new Object[2];
//        rr[0] = resultParam.getInput().get();
//        rr[2] = resultParam.getOutput().get();
//        //return rr;

        return new Object[]{
                resultParam.getInput().get()
                , resultParam.getOutput().get()
        };
    }

}
