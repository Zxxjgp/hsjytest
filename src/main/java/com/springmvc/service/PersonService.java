package com.springmvc.service;

import com.springmvc.pojo.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAllList();
    int updateandinsert(Person person);
}
