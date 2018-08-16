package com.springmvc.service.impl;

import com.springmvc.dao.EachertsDao;
import com.springmvc.dao.MapDao;
import com.springmvc.pojo.Eacherts;
import com.springmvc.pojo.Map;
import com.springmvc.service.EachertsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EachertsServiceImpl implements EachertsService {
    @Resource
    private EachertsDao eachertsDao;
    @Resource
    private MapDao mapDao;
    @Override
    public List<Eacherts> findalllist() {
        return eachertsDao.findAllList();
    }

    @Override
    public List <Map<Number, String>> selectall() {
        return mapDao.selectall();
    }
}
