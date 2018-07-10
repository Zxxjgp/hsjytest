package com.springmvc.service.impl;

import com.springmvc.dao.ProjectResruitDao;
import com.springmvc.pojo.ProjectResruit;
import com.springmvc.service.ResruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ResruitServiceImpl implements ResruitService {


    @Resource
    private ProjectResruitDao projectResruitDao;

    @Override
    public List<ProjectResruit> findAllList(ProjectResruit entity) {
        return projectResruitDao.findAllList();
    }
}
