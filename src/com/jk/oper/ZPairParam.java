package jk.oper;

public class ZPairParam<T,R> {
    ZParam<T> input;
    ZParam<R> output;

    public ZPairParam(T in, R out){
        input = new ZParam<>(in);
        output = new ZParam<>(out);
    }

    //
    public ZParam<T> getInput() {
        return input;
    }

    public void setInput(ZParam<T> input) {
        this.input = input;
    }

    public ZParam<R> getOutput() {
        return output;
    }

    public void setOutput(ZParam<R> output) {
        this.output = output;
    }
}
