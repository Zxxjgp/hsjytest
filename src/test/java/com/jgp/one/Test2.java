package com.jgp.one;

public class Test2
{
    public void add(Byte b)
    {
        b = b++;
    }
    public void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
        System.out.println(100%3+"......................");
        System.out.println(100%3.0+"33333333333");

    }

    public static void main(String[] args){
        int i = 1 ;
        int j = i++ ;
        if((i==(++j))&&((i++)==j))     {
            i += j ;
        }
        System.out.println("i = "+i);
        boolean flag = 10%2 == 1 && 10 / 3 == 0 && 1 / 0 == 0 ;
        System.out.println(flag ? "mldn" : "yootk") ;
        int sum = 0 ;
        for (int x = 0 ; x < 10 ; x ++) {
            sum += x ;
            if (x % 3 == 0) {
                break ;
            }
        }
        System.out.println(sum) ;

    }
}