package com.springmvc.service.impl;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.springmvc.pojo.DiseaseType;
import com.springmvc.pojo.Hospital;
import com.springmvc.service.DiseaseTypeService;
import com.springmvc.service.HospitalService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 初始化组件 把招募信息 根据招募类别分类信息 根据日期归档分类信息 存放到application中，用以提供页面请求性能
 * @author Administrator
 *
 */
@Component

public class InitComponent implements ServletContextListener,ApplicationContextAware{


    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        this.applicationContext=applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application=servletContextEvent.getServletContext();
        System.out.println("listener以及启动了");
        DiseaseTypeService blogTypeService=(DiseaseTypeService) applicationContext.getBean("diseaseTypeService");
        List<DiseaseType> hospitalList=blogTypeService.findists();
        application.setAttribute("hospitalList", hospitalList);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

}
