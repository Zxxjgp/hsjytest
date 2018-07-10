package com.springmvc.service.impl;

import com.springmvc.dao.HospitalDao;
import com.springmvc.pojo.Hospital;
import com.springmvc.service.HospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Resource
    private HospitalDao hospitalDao;
    @Override
    public List<Hospital> findlist(String id) {
        return hospitalDao.findlist(id);
    }

    @Override
    public int delestate(String id) {
        return hospitalDao.delestate(id);
    }

    @Override
    public List <Hospital> findalllist(Map<String,Object> map) {
        return hospitalDao.findalllist(map);
    }

    @Override
    public Long getTotal(Map <String, Object> map) {
        return hospitalDao.getTotal(map);
    }

    @Override
    public int add(Hospital hospital) {
        return hospitalDao.add(hospital);
    }

    @Override
    public int update(Hospital hospital) {
        return hospitalDao.update(hospital);
    }
    @Override
    public int delete(String id) {
        return hospitalDao.delestate(id);
    }

    @Override
    public List <Hospital> searchhospital(String userName) {
        return hospitalDao.searchhospital(userName);
    }

    @Override
    public List <Hospital> findists() {
        return hospitalDao.findists();
    }

}
