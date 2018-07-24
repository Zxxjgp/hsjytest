package com.utils.collectors;

import com.springmvc.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: hsjytest
 * @Package: com.utils.collectors
 * @ClassName: CollectorsTest
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/7/24 16:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/7/24 16:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CollectorsTest {
    public static void main(String[] args) {
        Collectors.toList();
    }
    @Test
    public void getdaba(){/*
        List<String> list = new ArrayList<>();
        list.add("秦朗");
        list.add("秦朗");
        list.add("秦朗");
        list.add("帅哥");
        list.add("美女");
        list.add("胖子");
        list = list.stream().distinct().collect(Collectors.toList());*/
 /*       List<Person> person=  new ArrayList<>();
        Person g = new Person();
        g.setId("21");
        g.setUsername("dage");
        person.add(g);
        List<String> lists = person.stream().map(Person::getUsername).collect(Collectors.toList());
        person.stream().map(Person::getId).collect(Collectors.toList());*/
      //  lists.stream().forEach(x-> System.out.printf(x));
     //   System.out.println(list.size());

        //集合数组的去重方式都是一样的
/*        List list =Arrays.asList("秦朗","秦朗","","帅哥","美女","胖子");
        List<String> gt = new ArrayList<>();
        gt.add("秦朗");
        gt.add("秦朗");
        gt.add("秦朗");
        gt.add("帅哥");
        gt.add("美女");
        gt.add("胖子");
        List<String> gtt= gt.stream().distinct().collect(Collectors.toList());
        System.out.println(gtt.size());
        List<String> l= (List<String>) list.stream().distinct().collect(Collectors.toList());
        System.out.println(l.size());*/
/*        String [] gg = {"秦朗","秦朗","秦朗","帅哥","美女","胖子"};
        Stream<String> gt = Arrays.stream(gg).distinct().sorted();
        gt.forEach(System.out::println);*/

    //    System.out.println(gt[0]);

/*
        List<String> list =Arrays.asList("秦朗","秦朗","23","帅哥","美女","胖子","蓝天","白云","流水","小号","人家","你好");
        List<String> count =  list.stream().limit(10).collect(Collectors.toList()); //只需要去前面的前0个
        long coun = list.stream().distinct().count(); //获取总的数量

        list.stream().sorted().collect(Collectors.toList()).forEach(System.out::println); //可以对集合进行排序处理
        String str = list.stream().distinct().collect(Collectors.joining("_"));
        System.out.println(str);
        System.out.println(coun);
        System.out.println(count.size());
*/


        List<Integer> integers =  Arrays.asList(3,2,3,1,2,5,6,8,56,65);
/*        IntSummaryStatistics summaryStatistics = integers.stream().mapToInt(x -> x*x).summaryStatistics();
        System.out.println("最大数"+summaryStatistics.getMax());
        System.out.println("最小数"+summaryStatistics.getMin());
        System.out.println("平均数"+summaryStatistics.getAverage());
        System.out.println("所有数之和"+summaryStatistics.getSum());

        integers.stream().filter(num -> num%2 == 0).collect(Collectors.toList()).forEach(System.out::println);*/
        //还可以进行数据的查找功能的实现
      //  boolean result = integers.stream().allMatch( x -> x >= 0); //表示前部满足条件

      //  boolean result = integers.stream().anyMatch( x -> x == 5);   //只要存在一个类的集合

       //  boolean result = integers.stream().noneMatch( x -> x == 0); //用来检车里面是否存在这么一种

      //  System.out.println(result);
    }
}
