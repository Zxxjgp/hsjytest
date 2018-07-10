package com.springmvc.dao;

import com.springmvc.common.dao.CrudDao;
import com.springmvc.pojo.Hospital;

import java.util.List;
import java.util.Map;

/**
 * @date 2018.4.22
 * @author jgp
 */
public interface HospitalDao extends CrudDao<Hospital>{

    List<Hospital> findlist(String id);
    int delestate(String id);

    List<Hospital> findalllist (Map<String,Object> map);

    Long getTotal(Map<String,Object> map);

    int add(Hospital hospital);
    List<Hospital> searchhospital(String userName);

    List<Hospital> findists();
}
