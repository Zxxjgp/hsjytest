package com.jgp.test;

import org.junit.Test;

public class Hy {

    public static void main(String args[])
    {
        System.out.println("Hello World!");
        System.out.println(inc(10)+inc(8)+inc(-20));

        int num =2147483647;
        num +=2;
        System.out.println("===================="+num);
        int d = 2;
        d = d++*2;
        System.out.println(d);

        int x = 10;
        double y = 20.2;
        long z = 10L;
            String str = ""+x+y*z;
        System.out.println(str);

    }
    public static  int inc( int temp ){
        if (temp > 0){
            return temp*2;

        }
        return -1;
    }

}
