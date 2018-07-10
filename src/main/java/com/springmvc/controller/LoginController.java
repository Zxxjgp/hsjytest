package com.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2018.4.22
 * @author jgp
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/login")
    public  String index(Model model){
        Map<String,String> map=new HashMap <>();
        map.put("stateCode","2");
        model.addAttribute(map);
        return "/manager/main";
    }
}
