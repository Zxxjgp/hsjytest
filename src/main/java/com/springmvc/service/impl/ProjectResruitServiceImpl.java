package com.springmvc.service.impl;

import com.springmvc.dao.ProjectResruitDao;
import com.springmvc.pojo.ProjectResruit;
import com.springmvc.service.ProjectResruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProjectResruitServiceImpl implements ProjectResruitService {

    @Resource
    private ProjectResruitDao projectResruitDao;

    @Override
    public List<ProjectResruit> findList(ProjectResruit entity) {
        return projectResruitDao.findList(entity);
    }

    @Override
    public ProjectResruit findproject( String id) {
        return projectResruitDao.findproject(id);
    }

    @Override
    public int delestate(String id) {
        return projectResruitDao.delestate(id);
    }

    @Override
    public int addstate(String id) {
        return projectResruitDao.addstate(id);
    }

    @Override
    public int add(ProjectResruit projectResruit) {
        return projectResruitDao.add(projectResruit);
    }

    @Override
    public List <ProjectResruit> findalllist(Map<String, Object> map) {
        return projectResruitDao.findalllist(map);
    }

    @Override
    public Long getTotal(Map <String, Object> map) {
        return projectResruitDao.getTotal(map);
    }

    @Override
    public List <ProjectResruit> searchhospital(String userName) {
        return projectResruitDao.searchhospital(userName);
    }

    @Override
    public int queryall() {
        return projectResruitDao.queryall();
    }

}
