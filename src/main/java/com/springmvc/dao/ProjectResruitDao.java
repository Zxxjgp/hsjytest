package com.springmvc.dao;

import com.springmvc.common.dao.CrudDao;
import com.springmvc.pojo.ProjectResruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @date 2018.4.22
 * @author jgp
 */
public interface ProjectResruitDao extends CrudDao<ProjectResruit> {
    ProjectResruit findproject(String id);
    int delestate(String id);
    int addstate (String id);
    int add(ProjectResruit projectResruit);


    List<ProjectResruit> findalllist (Map<String,Object> map);
    Long getTotal(Map<String,Object> map);

    List<ProjectResruit> searchhospital(String userName);
    int queryall();
}
