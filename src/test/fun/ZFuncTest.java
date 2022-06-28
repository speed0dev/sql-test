package fun;

import jk.fun.ZFunc;
import org.junit.jupiter.api.Test;

public class ZFuncTest {

    @Test
    void callFunc(){
        System.out.println("@@@ #### ");

        ZFuncExample ex = new ZFuncExample();
        try {
            ex.excute();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
