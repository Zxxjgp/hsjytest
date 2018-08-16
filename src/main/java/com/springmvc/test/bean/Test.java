package com.springmvc.test.bean;

import com.springmvc.study.utils.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.test.bean
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/7/26 16:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/7/26 16:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
/*        List<Student> list = new ArrayList<>();
        list.add(new Student("小哥","女人", "lalalalaalala"));
        Student student = new Student("大哥","女人", "null");
        Person person = new Person("11","老师","女",student,list);
        Person person1 = new Person();

        BeanUtils.copyProperties(person,person1);
        student.setFactior("地球人");
        list.get(0).setGirlFriends("我爱你中国，你会在哪里啊啊，在哪里啊");
        System.out.println(person);
        System.out.println(person1);*/
        String[] str={"王波","小鸟",""};
        String strt = " d h ";
        QInlang qInlang = null;
        System.out.println(StringUtils.isEmpty(qInlang));
        System.out.println(StringUtils.delete("qw123qwqw","123qw")); //删除制定字符串的数据
        System.out.println(StringUtils.delete("abcdefg","b"));    //将特定的字符串拿掉
        System.out.println(str.length);
        System.out.println(StringUtils.addStringToArray(str,"789").length);
        System.out.println(StringUtils.hasLength(strt));         //判断字符串的长度，空格也进行了计算
        System.out.println(StringUtils.hasText("      沃尔沃"));     //空格没有计算
        System.out.println(strt.length());
        System.out.println(StringUtils.trimArrayElements(str).length);
        System.out.println(StringUtils.trimAllWhitespace(strt).length());
        System.out.println(StringUtils.trimWhitespace(strt).length());

    }
    @org.junit.Test
    public  void gr(){

    }

}
