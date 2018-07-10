package com.jgp.list;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Lanmber {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("秦朗");
        list.add("秦朗");
        list.add("秦朗");
        list.add("帅哥");
        list.add("美女");
        list.add("胖子");

        list.forEach((sd) -> System.out.println(sd));
        list.forEach(System.out::println);

        Properties properties = new Properties();
        properties.setProperty("bj","北京");
        properties.setProperty("nj","南京");
        properties.store(new FileOutputStream(new File("D:"+File.separator+"area.properties")),"刚刚拿进去的数据");

        properties.load(new FileInputStream(new File("D:"+File.separator+"area.properties")));
        System.out.println(properties.getProperty("bj"));
    }

    public static  void  hg(String ... keys){
        List<String> list = new ArrayList<>();
        for (String str: keys) {
            list.add(str);
        }
        System.out.println(list);
    }
}
