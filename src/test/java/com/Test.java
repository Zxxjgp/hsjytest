package com;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
  /*      List<Object> list1 = new ArrayList <>();
        Person person = new Person();
        list1.add(person);
        String str =  JSON.toJSONString(list1);
        System.out.println(str);

        String re = "[{\"id\":\"12\",\"name\":\"张三\"}, {\"id\":\"12\",\"name\":\"张三\"}]";
        List<Object>  list3 = JSONArray.parseArray(re);
        System.out.println(list3);
        List<String> list2 = new ArrayList <>();*/
       /* Hsjy hsjy= () -> System.out.printf("45");
        hsjy.get();*/
        //hy(() -> System.out.printf("45"));
        hy(new Hsjy() {
            @Override
            public void get() {

            }
        });
    }

    public static void hy(Hsjy hsjy){
        hsjy = () -> System.out.printf("45");
        hsjy.get();
    }
}
