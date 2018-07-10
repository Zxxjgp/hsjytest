package com.springmvc.test;

import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

public class JsonToMap {
    public static void main(String [] args){
        String str="{\"head\": [  \n" +
                "       {\"text\":\"广州\",\"id\":\"广州\",\"pid\":\"广东省\"},  \n" +
                "       {\"text\":\"郑州\",\"id\":\"郑州\",\"pid\":\"河南省\"}],  \n" +
                "}";

        Map<String,Object> rs= JSONObject.fromObject(str);
        List<Map<String,Object>> list = (List <Map <String, Object>>) rs.get("head");
        System.out.println(list.get(0).get("text"));
        System.out.println("wewq");
    }
}
