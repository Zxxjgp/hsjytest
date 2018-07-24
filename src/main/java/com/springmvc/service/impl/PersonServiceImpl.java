package com.springmvc.service.impl;

import com.springmvc.dao.PersonDao;
import com.springmvc.pojo.Person;
import com.springmvc.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonDao personDao;

    @Override
    public List<Person> findAllList() {
        return personDao.findAllList();
    }

    @Override
    public int updateandinsert(Person person) {
        return personDao.updateandinsert(person);
    }
}
