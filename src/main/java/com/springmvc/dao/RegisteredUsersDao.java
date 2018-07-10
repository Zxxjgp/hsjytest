package com.springmvc.dao;

import com.springmvc.common.dao.CrudDao;
import com.springmvc.pojo.RegisteredUsers;

public interface RegisteredUsersDao extends CrudDao<RegisteredUsers> {
    int finds();
}
