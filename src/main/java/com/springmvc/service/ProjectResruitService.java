package com.springmvc.service;

import com.springmvc.pojo.ProjectResruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @date 2018.4.22
 * @author jgp
 */
public interface ProjectResruitService {
    List<ProjectResruit> findList(ProjectResruit entity);

    ProjectResruit findproject( String id);
    int delestate(String id);
    int addstate (String id);
    /**
     * 插入项目与医院的管理
     * @param
     * @return
     */
    int add(ProjectResruit projectResruit);
    List<ProjectResruit> findalllist (Map<String,Object> map);
    Long getTotal(Map<String,Object> map);

    List<ProjectResruit> searchhospital(String userName);
    int queryall();
}
