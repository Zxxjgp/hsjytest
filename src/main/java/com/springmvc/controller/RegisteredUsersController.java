package com.springmvc.controller;

import com.springmvc.pojo.RegisteredUsers;
import com.springmvc.service.RegisteredUsersService;
import com.springmvc.utils.MakeUUID;
import com.springmvc.utils.ResponseUtil;
import com.springmvc.utils.ServerFileUploadUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "resuser")
public class RegisteredUsersController {
    @Resource
    private RegisteredUsersService registeredUsersService;
    @Resource
    private HttpServletRequest request;

    @RequestMapping("add")
    public  String addRegisteredUsers(RegisteredUsers registeredUsers, HttpServletResponse response) throws Exception{
        registeredUsers.setId(MakeUUID.makerandomuuid());
        int res= registeredUsersService.insert(registeredUsers);
        JSONObject result = new JSONObject();
        if (res > 0){
            result.put("success",true);
            ResponseUtil.write(response, result);
        }else {
            result.put("success",true);
            ResponseUtil.write(response, result);
        }
        return null;
    }
    @RequestMapping("/loadup")
    public String loadup(@RequestParam("file")MultipartFile file, Model model){
        String fileName=null;
        try {
            fileName = ServerFileUploadUtil.load(file, request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("dddString", fileName);
        System.out.println("++++++++++++"+fileName);
        return "/hospitalrecruitment/enrolmentmethod";
    }
}
