package com.springmvc.test.Map;

import com.springmvc.test.bean.Person;
import com.springmvc.test.bean.QInlang;
import com.springmvc.test.bean.Student;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.test.Map
 * @ClassName: MapTest
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/7/31 17:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/7/31 17:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MapTest {
    private String className;
    private String studentName;

    public static void main(String[] args) {
/*
        List<MapTest> list = new ArrayList<>();
        list.add(new MapTest("一年级二班", "小明"));
        list.add(new MapTest("一年级二班", "小芳"));
        list.add(new MapTest("一年级二班", "小华"));
        list.add(new MapTest("一年级三班", "翠花"));
        list.add(new MapTest("一年级三班", "香兰"));
        list.stream().distinct();
        // 集合中对象属性转map
        Map<String, String> map = list.stream().collect(Collectors.toMap(MapTest:: getClassName, MapTest :: getStudentName,((key1 , key2)-> key1 )));
        System.out.println(map.get("一年级二班"));*/
    }

    @Test
    public void ge(){
        QInlang person  = new QInlang();
        boolean empty = StringUtils.isEmpty(person);
        System.out.println(empty);
    }

}
