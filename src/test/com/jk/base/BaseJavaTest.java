package com.jk.base;

import jk.oper.data.OperIn;
import jk.oper.data.OperOut;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BaseJavaTest {

    // hashCode를 이용한 객체생성 비교
    @Test
    void CallTest(){
        System.out.println("=== step01 --------");
        int h = hashCode();
        System.out.println(h);

        OperIn in = new OperIn();
        OperOut out = new OperOut();

        OperIn in2 = in;
        OperIn in3 = new OperIn();
    
        // hashCode 로 비교
        System.out.println( in.hashCode() + " " + in2.hashCode() + " " + in3.hashCode() );

    }

    // map merge 사용법 (이전값 , 이후값 , 더한값)
    @Test
    void mapTest(){
        HashMap<String,Integer> fruits1 = new HashMap<>();
        fruits1.put("apple", 100);
        fruits1.put("kiwi", 300);
        fruits1.put("grape", 400);

        HashMap<String,Integer> fruits2 = new HashMap<>();
        fruits2.put("banana", 500);
        fruits2.put("kiwi", 600);
        fruits2.put("melon", 700);

        //1. 이전값
        fruits2.forEach((key, value)-> fruits1.merge(key, value, (v1,v2)-> v1));
        System.out.println(fruits1);

        //2. 이후값
        fruits2.forEach((key, value)-> fruits1.merge(key, value, (v1,v2)-> v2));
        System.out.println(fruits1);

        //2. 이후값
        fruits2.forEach((key, value)-> fruits1.merge(key, value, (v1,v2)-> v1 + v2));
        System.out.println(fruits1);
    }
}
