package com.springmvc.dao;

import com.springmvc.pojo.Test;

import java.util.List;

public interface TestDao {
    List<Test> find();
    int insertlist(Test test);
    int listinsert(String[] list);

    int listsert(List<Test> list);
}
