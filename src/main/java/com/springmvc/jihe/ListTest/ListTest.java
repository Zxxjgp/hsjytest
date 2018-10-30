package com.springmvc.jihe.ListTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.jihe.ListTest
 * @ClassName: ListTest
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/10/23 20:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/23 20:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(16);
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        list.add("3");
        list.stream().distinct();
        System.out.println(list);

        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

        int i = 0;

        switch (i) {

            case 0:

                System.out.println("zero");

            case 1:

                System.out.println("one");

            case 2:

                System.out.println("two");

                break;

            case 3:
                System.out.println("three");
        }

        System.out.println(i++);
    }
}
