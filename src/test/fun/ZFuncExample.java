package fun;

import com.sun.jdi.VoidType;
import jk.fun.ZFunc;
import jk.oper.ZPairParam;

public class ZFuncExample {

    public ZFuncExample(){

    }

    public void excute() throws Exception{
        init();
        makeRoop();
        callA();
        callB();

        //
        ZFunc<ZPairParam<String,String>,ZPairParam<String,String>> fpInit = (p)->{
            init(); //
            System.out.println(" @ fInit()");
            return p;
        };

        // setp001
        ZFunc<ZPairParam<String,String>,ZPairParam<String,String>> fpMakeRoop = this::makeRoop;

        // setp002
        ZFunc<ZPairParam<String,String>,ZPairParam<String,String>> fpcallA = this::callA;

        // setp003
        ZFunc<ZPairParam<String,String>,ZPairParam<String,String>> fpcallB = this::callB;

        // method add
        fpInit.compose(fpMakeRoop.compose(fpcallA.compose(fpcallB))).apply(new ZPairParam<String,String>("AAAAAAAAA", "bbbbb"));

        // methodRoop

        System.out.println("###################################");
        System.out.println("###################################");
        System.out.println("###################################");
        // 좀더 심플하게 처리할것.
        fpInit.andThen(fpMakeRoop.andThen(fpcallA.andThen(fpcallB))).apply(new ZPairParam<String,String>("AAAAAAAAA", "bbbbb"));

    }

    private ZPairParam<String, String> callB(ZPairParam<String, String> param) throws Exception{
        System.out.println(" @ callB()");
        //throw new Exception("callB() Exception");
        return param;
    }

    private ZPairParam<String, String> callA(ZPairParam<String, String> param) throws Exception{
        System.out.println(" @ callA()");

        //throw new Exception("callAAAAAAAAA  () ");
        return param;
    }

    //
    private ZPairParam<String, String> makeRoop(ZPairParam<String, String> stringStringZPairParam) throws Exception{
        System.out.println(" @ makeRoop()");

        return null;
    }

    //
    private void init() {
        //

    }


    //
    private void makeRoop() {

    }
    //
    private void callA() {

    }

    //
    private void callB() {

    }






}
