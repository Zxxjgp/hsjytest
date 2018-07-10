package com.springmvc.test.fanxin;
@FunctionalInterface //函数接口 里面只可以有一个接口
interface Me{
    void print(String s);

}
interface Math{
    int add(int x , int y);

}
public class Lamber {
    public static void main(String[] args){
        Me message = (s) -> {
            System.out.println("我们都是好孩子");
            System.out.println("我们都是好孩子");
        };
        message.print("we");
        Math math = (p1, p2) ->2;
        System.out.println(math.add(10,20));
    }
}
