package fun;

import jk.oper.CFComponent;
import jk.oper.data.OperIn;
import jk.oper.data.OperOut;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

class XParam{
    public Object input;
    public Object output;
    public XParam(Object p1, Object p2){
        this.input = p1;
        this.output = p2;
    }
}

public class FuncTest {

    @Test
    void FuncCompTest(){
        String in = "aaaa";
        String out = "bbbb";
        CFComponent fComp = new CFComponent();
        fComp.setFunc("setting", (param)->{
            System.out.println("00 setting <<" + param);
            System.out.println("input>" + param.getInput().get() + " output>" + param.getOutput().get());
            return param;
        });
        fComp.execute(in,out);

    }

    @Test
    void FuncCompTestOper(){
        //
        OperIn in = new OperIn();
        OperOut out = new OperOut();

        System.out.println("[start]" + in+ " " + out);

        CFComponent fComp = new CFComponent();
        fComp.setFunc("setting", (param)->{
            System.out.println("[setting]" + param);
            System.out.println("input>" + param.getInput().get() + " output>" + param.getOutput().get());
            return param;
        });
        Object[] result = fComp.execute(in,out);
        OperIn rIn = (OperIn)result[0];
        OperOut rOut = (OperOut)result[1];

        System.out.println("[end]" + rIn + " " + rOut);

    }

    
    // stream 으로 처리
    @Test
    void FuncCompTestOperList(){
        //
        String[] datas = new String[]{"aaaa", "bbbb", "cccc", "ddddd"};
        Object empty = null;

        //
        CFComponent fComp = new CFComponent();
        fComp.setFunc("setting", (param)->{
            System.out.println("[setting]" + param);
            String[] strs = (String[]) param.getInput().get();
            for(int i=0;i<strs.length;i++){
                strs[i] = "{Add 001" + strs[i] + "}";
            }
            return param;
        });

        Object[] result = fComp.execute(datas, empty);
        String[] rIn = (String[])result[0];
        Object rOut = result[1];

        System.out.println("[end]" + rIn + " " + rOut);
        for(String r : rIn){
            System.out.println(r);
        }

    }




    @Test
    void callTest(){
        System.out.println("@@ callTest() ");

        Function<Integer, Integer> f1 = n -> n*n;
        Function<Integer, String> f2 = n-> "result:" + n;

        String result = f1.andThen(f2).apply(10);

        System.out.println(result);
    }

    //
    // case -> n Function
    // multi Test
    // compose() <== 합성해서 하나로
    @Test
    void compTest(){
        Function<Integer,Integer> addZero = n -> n+(n+1); //3
        Function<Integer, Double> add = n -> n+2.0;
        Function<Double,Double> multi = n -> n*5.0; //
        Function<Integer,Double> addAndMulti = multi.compose(add); // 합성 function

        Function<Integer,Double> addAndMulti2 = addAndMulti.compose(addZero); //

        Double result = addAndMulti.apply(1);
        System.out.println("[result]" + result);

        Double result2 = addAndMulti2.apply(1);
        System.out.println("[result2]" + result2);

    }

    // input -> output 동일
    @Test
    void callCheckout(){
        Function<XParam, XParam> f1 = (param)->{
            System.out.println("!! f1.call() ");
            return param;
        };

        Function<XParam, XParam> f2 = (param) ->{
            System.out.println("!! f2.call() ");
            return param;
        };
        Function<XParam, XParam> f3 = (param)->{
            System.out.println("!! f3.call() ");
            return param;
        };

        // f
        XParam p = f1.andThen(f2.andThen(f3)).apply(new XParam("AAA", "BBB"));

    }


}
