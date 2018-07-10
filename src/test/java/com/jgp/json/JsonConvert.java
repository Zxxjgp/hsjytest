package com.jgp.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonConvert {
    public static  void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("秦朗");
        list.add("秦朗");
        list.add("秦朗");
        list.add("帅哥");
        list.add("美女");
        list.add("胖子");
        String [] str = {"气囊","秦朗","秦朗","秦朗"};
        Map<String, Object> map=  new HashMap <>();
        String json2 ="{\"type\":\"slider\",\"show\":\"true\",\"start\":1,\"end\":100}";
        JSONObject[] dataZoom = new JSONObject[]{JSONObject.parseObject("{\"type\":\"slider\",\"show\":\"true\",\"start\":1,\"end\":100}")};

        map.put("list",list);
        map.put("str",str);
/*        String strs= JSON.toJSON(list).toString();
        String strss= JSON.toJSON(str).toString();
        System.out.println(strs);
        System.out.println(strss);*/
        JSONObject json = JSONObject.parseObject(json2);
        System.out.println(JSON.toJSON(map).toString());
        System.out.println(JSON.toJSONString(list));
        System.out.println(json);
        System.out.println(dataZoom[0]);
    }
}
