package com.springmvc.dao;

import com.springmvc.common.dao.CrudDao;
import com.springmvc.pojo.Map;

import java.util.List;

/**
 * @date 2018.4.22
 * @author jgp
 */
public interface MapDao extends CrudDao<Map> {
       List<Map> selectall();
}
