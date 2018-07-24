package com.springmvc.controller;

import com.springmvc.pojo.Person;
import com.springmvc.service.PersonService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author HSHY-394
 */
@Controller
@RequestMapping(value ="/index")
public class IndexController {
    @Resource
    private PersonService personService;
    @RequestMapping(value = "/index")
    public  String index(Model model){
            Map<String,String> map=new HashMap<>();
        map.put("stateCode","2");
        model.addAttribute(map);
        return "/datadispaly/yesterdaydisplay";
    }
    @RequestMapping(value = "/upin")
    private int updateInert(@RequestBody Person person){
       String id= person.getId();
        return personService.updateandinsert(person);
    }
    @RequestMapping(value = "/conversion")
    private int conversion(@RequestBody Person person){
        String id= person.getId();
        List<Person> platformList=new ArrayList<>();
        platformList = Arrays.asList(person);
        String trsult = platformList.get(0).getUsername();
        return 1;
    }
}
