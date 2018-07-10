package com.jgp.one;

public class Testlu {
    public void method()
    {
        try
        {
            System.out.println("进入到try块");
        }
        catch (Exception e)
        {
            System.out.println("异常发生了！");
        }
        finally
        {
            System.out.println("进入到finally块");
        }
        System.out.println("后续代码");
    }
    public static void main(String[] args)
    {
        Testlu test = new Testlu();
        test.method();
    }
}
