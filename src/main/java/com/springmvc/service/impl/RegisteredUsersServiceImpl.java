package com.springmvc.service.impl;

import com.springmvc.dao.RegisteredUsersDao;
import com.springmvc.pojo.RegisteredUsers;
import com.springmvc.service.RegisteredUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisteredUsersServiceImpl implements RegisteredUsersService {
    @Resource
    private RegisteredUsersDao registeredUsersDao;

    @Override
    public int insert(RegisteredUsers registeredUsers) {
        return registeredUsersDao.insert(registeredUsers);
    }

    @Override
    public int finds() {
        return registeredUsersDao.finds();
    }
}
