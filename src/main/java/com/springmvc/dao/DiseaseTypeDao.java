package com.springmvc.dao;

import com.springmvc.common.dao.CrudDao;
import com.springmvc.pojo.DiseaseType;

import java.util.List;
import java.util.Map;

/**
 * @date 2018.4.22
 * @author jgp
 */
public interface DiseaseTypeDao extends CrudDao<DiseaseType> {
    int delestate(String id);

    List<DiseaseType> findalllist (Map<String,Object> map);

    Long getTotal(Map<String,Object> map);

    int add(DiseaseType diseaseType);
    List<DiseaseType> searchdiseasetype(String userName);

    List<DiseaseType> findists();
    List<DiseaseType> finds();

    DiseaseType testfindnull();
}
