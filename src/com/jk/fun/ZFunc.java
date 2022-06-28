package jk.fun;

import jk.oper.ZPairParam;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface ZFunc<T, R> {
    R apply(T t) throws Exception ;

    //
    default <V> ZFunc<V, R> compose(ZFunc<? super V, ? extends T> before) throws Exception{
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v)); // casting
    }

    default <V> ZFunc<T,V> andThen(ZFunc<? super R, ? extends V > after) throws Exception{
        Objects.requireNonNull(after);
        return (T t) -> {
                return after.apply(apply(t));
        }; //
    }


}
