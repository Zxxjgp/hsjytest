package com.jgp.one;

import com.jgp.test.Test;

import java.util.HashMap;

public class StringTest {
    public static  void main(String[] args){
        StringBuilder sb = new StringBuilder();
        sb.append("你会在那里等着我").append("wozaizheli");
        System.out.println("int byte long char short boolean double float");
        System.out.println(sb.toString());
        int num = 10;
        System.out.println(test(num));
        Test2 t = new Test2();
        t.test();
    }
    public  static  int test(int b){
        try {
            b += 10;
            return b;
        }catch (RuntimeException e){

        }catch (Exception e){}

        finally {
            b += 10;
            return b;
        }
    }

}
