package com.springmvc.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.test
 * @ClassName: FuntionTest
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/7/26 20:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/7/26 20:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FuntionTest {
    public static void main(String[] args) {
        //这个例子讲解Function中compose和andThen的区别
        FuntionTest test = new FuntionTest();

        int result = test.functionCompose(10, value -> value * 2, value -> value * value);
        System.out.println("result = [" + result + "]");

        int result2 = test.functionAndThen(10, value -> value * 2, value -> value * value);
        System.out.println("result2 = [" + result2 + "]");

        System.out.println("---------------------------");
        /**
         *  我们调用Function的apply(a)可以传入一个参数得到一个结果，但是这个类无法做到输入2个参数，得到一个结果，
         *  BiFunction可以做到这一点。Bi==Bidirectional双向的意思
         */
        int result3 = test.biFunctionCaculate(30, 20, (value1, value2) -> value1 + value2);
        System.out.println("result3 = [" + result3 + "]");

        int result4 = test.biFunctionCaculate(30, 20, (value1, value2) -> value1 - value2);
        System.out.println("result4 = [" + result4 + "]");

        int result5 = test.biFunctionAndThen(30, 20, (value1, value2) -> value1 - value2, value -> value * value);
        System.out.println("result5 = [" + result5 + "]");
        String[] strs = {"java", "C#", "C++", "php", "javascrip","java"};


        List<String> collect = Stream.of(strs)
                .map(s -> s.split(""))
                .distinct()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        collect.forEach(s-> System.out.println(s+": "));


    }

    public int functionCompose(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        //(V v) -> apply(before.apply(v));
        // 先应用function2的apply，并将结果作为参数再应用function1的apply
        return function1.compose(function2).apply(a);
    }

    public  static  int compare(int a,Function<Integer,Integer> function1 , Function<Integer,Integer> function2){

        return function1.compose(function2).apply(a);
    }

    public  static  int compared(int a,Function<Integer,Integer> function1){

        return function1.apply(a);
    }

    public int functionAndThen(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        //(T t) -> after.apply(apply(t))
        // 先应用function1的apply，并将结果作为参数再应用function2的apply
        return function1.andThen(function2).apply(a);
    }

    public int biFunctionCaculate(int a, int b, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(a, b);
    }

    //BiFunction没有compose方法
    /*@Deprecated
    public int biFunctionCompose(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function){
        //return biFunction.compose(function).apply(a, b);
    }*/

    public int biFunctionAndThen(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function){
        return biFunction.andThen(function).apply(a, b);
    }

    @Test
    public void gt(){
        java7_biFunction();
        java8_biFunction();
    }

    private static void java7_biFunction() {
        BiFunction<String, String, String> bi = new BiFunction<String, String, String>(){
            @Override
            public String apply(String t, String u) {
                return t+u;
            }
        };
        Function<String, String> func = new Function<String, String>() {
            @Override
            public String apply(String t) {
                return t+"-then";
            }
        };
        System.out.println(func.apply("test"));//test-then
        System.out.println(bi.apply("java2s.com", "-tutorial"));//java2s.com-tutorial
        System.out.println(bi.andThen(func).andThen(func).apply("java2s.com", "-tutorial"));//java2s.com-tutorial-then-then
    }
    private static void java8_biFunction() {
        //java8新特性，lambda表达式
        BiFunction<String, String,String> bi = (x, y) -> {
            return x + y;
        };
        Function<String,String> func = x-> x+"-then";
        System.out.println(func.apply("test"));//test-then
        System.out.println(bi.apply("java2s.com", "-tutorial"));//java2s.com tutorial
        System.out.println(bi.andThen(func).andThen(func).apply("java2s.com", "-tutorial"));//java2s.com-tutorial-then-then
    }
}
