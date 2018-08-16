package com.springmvc.test;

import java.util.function.Function;

class Test {

    public static void main(String args[]) {

        String[] book = {"qqq","2222","dsds"};
        for (String b:
             book) {
            b = "32323";
            System.out.println(b);
        }


/*        int result = computes(5, 6, value -> value * value);
        System.out.println(result);
        int g=   computeqq(2, value -> value * 3, value -> value * value);
        System.out.println(g);*/
    }

    public static String compute(int a, Function<Integer, String> function) {
        String result = function.apply(a);
        return result;
    }

    public static int computes(int a, int b, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }

    public static int  computeqq(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }
}
