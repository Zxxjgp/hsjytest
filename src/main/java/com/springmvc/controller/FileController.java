package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @date 2018.4.22
 * @author jgp
 */
@Controller
@RequestMapping(value = "file")
public class FileController {
    @Resource
    private HttpServletRequest request;

    public String loadfile(){

        return null;
    }
}
