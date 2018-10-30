package com.springmvc.jihe.ListTest;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.jihe.ListTest
 * @ClassName: Three
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/10/23 22:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/23 22:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Three extends One {
    public static void aMethod(String str)

    {

        System.out.println("Hello" + str);

    }

    public static void main(String[] args) {
        String s = "Tom";

        Three.aMethod(s);
        int anar[]=new int[]{1,2,3};

        System.out.println(anar[1]);
    }
}
