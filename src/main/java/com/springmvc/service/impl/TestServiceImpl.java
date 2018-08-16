package com.springmvc.service.impl;

import com.springmvc.dao.TestDao;
import com.springmvc.exception.auth.AuthException;
import com.springmvc.pojo.Test;
import com.springmvc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jgp
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    public TestDao testDao;
    @Override
    public List<Test> find() {
        return testDao.find();
    }

    @Override
    public int insertlist(Test test) {
        return testDao.insertlist(test);
    }

    @Override
    public int listinsert(String[] list) {
        return testDao.listinsert(list);
    }
    @Override
    public int listsert(List<Test> list){
        return  testDao.listsert(list);
    }

    @Override
    public Test finding() {
        throw  new AuthException("Test Glober Exception");
    }

    @Override
    public List<Test> listDa() {
        return testDao.listDa();
    }
}
