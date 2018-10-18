package com.springmvc.study.utils;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.study.utils
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/10/18 14:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/18 14:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        String string = "abc";

        String str = new String("abc");
        System.out.println(str.hashCode());
        System.out.println(string.hashCode());

        System.out.println(str.equals(string));

        String str2 = new String("str")+new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2==str1);

/*        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));*/

        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());


    }
}
