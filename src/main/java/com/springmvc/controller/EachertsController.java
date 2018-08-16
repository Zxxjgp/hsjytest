package com.springmvc.controller;

import com.springmvc.pojo.ChinaMap;
import com.springmvc.pojo.Eacherts;
import com.springmvc.service.EachertsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author XX
 * @date 2018.4.24
 *
 */
@Controller
@RequestMapping(value = "ht")
public class EachertsController {

    @Resource
    private EachertsService eachertsService;


    @RequestMapping(value = "/ea", method= RequestMethod.GET)
    @ResponseBody
    private List<Map> eacherts(){
        List<Map> list=new ArrayList();
        //用来查询所有的有效数据
        List<Eacherts> list1 = eachertsService.findalllist();
        for (int i=0; i< list1.size() ;i++) {
            /**
             *多行注释应该是这个样子的，我们应该多多去学习
             */
            Map <String, String> map = new HashMap <>(32);
            map.put("value", Integer.toString(list1.get(i).getCount()));
            map.put("name",list1.get(i).getName());
            list.add(map);
        }
        return list;
    }
    @RequestMapping(value = "/maps", method= RequestMethod.GET)
    @ResponseBody
    private List mapseachertss(){


        List temp=new ArrayList();
        Map<String,String> map = new HashMap();
        //用来查询所有的有效数据
        List<com.springmvc.pojo.Map<Number, String>> list1 = eachertsService.selectall();
        for (int i = 0; i < list1.size(); i++) {
            List<String> vlu=new ArrayList();
            map.put("name", list1.get(i).getName());
            vlu.add(list1.get(i).getX());
            vlu.add(list1.get(i).getY());
            map.put("value",vlu.toString());
            temp.add(map);
            vlu.clear();
        }
        return temp;
    }

    @RequestMapping(value = "/map", method= RequestMethod.GET)
    @ResponseBody
    private List mapseacherts(){
        List result=new ArrayList();
        String[] str=new String[2];
        Map<String,String> mp = new HashMap <>();
        List<com.springmvc.pojo.Map<Number, String>> list = eachertsService.selectall();
        for (com.springmvc.pojo.Map<Number, String> mapeneity: list) {
            mp.put("name",mapeneity.getName());
            str[0] = mapeneity.getX();
            str[1] = mapeneity.getY();
            mp.put("value",str.toString());
            result.add(mp);
        }


        return  result;
    }


    @RequestMapping(value = "/china", method= RequestMethod.GET)
    @ResponseBody
    private List<ChinaMap> chinamap(){
        List<ChinaMap> re = new ArrayList();
        List<com.springmvc.pojo.Map<Number, String>> list = eachertsService.selectall();
        for(com.springmvc.pojo.Map<Number, String> map: list) {
            ChinaMap chinaMap = new ChinaMap();
            List<String> vlu=new ArrayList();
            chinaMap.setName(map.getName());
            vlu.add(map.getX());
            vlu.add(map.getY());
            chinaMap.setLists(vlu);
            re.add(chinaMap);
        }
        return  re ;
    }

}
