package com.utils.collectors;

import com.springmvc.pojo.Person;
import org.junit.Test;

import java.util.*;
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
    public void getdaba(){
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160005, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20160006, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20160007, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20160008, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20160009, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
            }
        };




        /*


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


   //     List<Integer> integers =  Arrays.asList(3,2,3,1,2,5,6,8,56,65);
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
/*        long count = integers.stream().count();
        System.out.println(count);*/
        // 前面例子中的方法
/*        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(Student::getAge).sum();*/
// 归约操作
/*        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0, (a, b) -> a + b);

// 进一步简化
        int totalAge2 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0, Integer::sum);

// 采用无初始值的重载版本，需要注意返回Optional
        Optional<Integer> e  = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(Integer::sum);  // 去掉初始值*/
       /* System.out.println(totalAge);*/
        //students.remove(0);
/*        System.out.println(students.size());

        Iterator<Student> iterator= students.iterator();
        while (iterator.hasNext()){
            Student next = iterator.next();
            if (20160001 == next.getId()){
                iterator.remove();
            }
        }*/
        System.out.println(students.size());


        System.out.println(
                Arrays.asList(new String[] { "a", "b" }));

        System.out.println(
                Arrays.asList(new Integer[] { 1, 2 }));

        System.out.println(
                Arrays.asList(new int[] { 1, 2 }));

        System.out.println(
                Arrays.asList(new String[] { "a", "b" }, "c"));
    }
}
