package com.springmvc.test;

import com.springmvc.test.enu.OrderState;

import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;



public class Serrch {

    public static  void main (String []args)throws  Exception{

        System.out.println(OrderState.WAITCONFIRM.getName());

      /*  Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }

        //第二种

        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String,String>> iterator= map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("wqiorrrrrrr"+entry.getKey() + "=========="+entry.getValue());
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }*/


/*        Date date= new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-20");
        System.out.println(date);

        List<String> list =  new ArrayList<String>();
        list.add("这个十几人");
        list.add("你们是二笔吗");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        System.out.println(array.length);*/

       // String[] str = new String[]{"you", "wu"};
       // List list = Arrays.asList(str);
       /* list.add("ewrewrew");*/
       // str[0] = "齐纳领的";
       // System.out.println(list.get(0));
/*        String str1 = "abcdefg";
        char ch1 = str1.charAt(0);
        System.out.println("使用charAt()方法" +
                "从字符串中提取字符,结果是：" + ch1);*/

        /*Comparator comparator= new Comparator();*/
    }

/*
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SerachBase serachBase = SerachBase.getSerachBase();
        serachBase.add("1", "你好！", "你好！");
        serachBase.add("2", "你好！我是张三。", "你好！我是张三。");
        serachBase.add("3", "今天的天气挺好的。", "今天的天气挺好的。");
        serachBase.add("4", "你是谁？", "你是谁？");
        serachBase.add("5", "高数这门学科很难", "高数确实很难。");
        serachBase.add("6", "测试", "上面的只是测试");
        String ids = serachBase.getIds("你的高数");
        System.out.println(ids);
        List<Object> objs = serachBase.getObjects(ids);
        if (objs != null) {
            for (Object obj : objs) {
                System.out.println((String) obj);
            }
        }
    }*/


}
