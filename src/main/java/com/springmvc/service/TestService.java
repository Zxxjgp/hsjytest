package com.springmvc.service;

import com.springmvc.pojo.Test;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TestService {
    List<Test>  find();
    int insertlist(Test test);
    int listinsert(String[] list);
    int listsert(List<Test> list);
    Test finding();
    List<Test> listDa();
}
