package com.springmvc.service;

import com.springmvc.dao.MapDao;
import com.springmvc.pojo.Eacherts;
import com.springmvc.pojo.Map;

import java.util.List;

public interface EachertsService {
    List<Eacherts> findalllist();
    List<Map> selectall();
}
