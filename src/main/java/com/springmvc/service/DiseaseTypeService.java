package com.springmvc.service;

import com.github.pagehelper.PageInfo;
import com.springmvc.pojo.DiseaseType;
import com.springmvc.utils.EUDataGridResult;
import com.springmvc.utils.Params;

import java.util.List;
import java.util.Map;

/**
 * @date 2018.4.22
 * @author jgp
 * @version 1.0
 */
public interface DiseaseTypeService {
    List<DiseaseType> findAllList(DiseaseType entity);
    int delestate(String id);
    int add(DiseaseType diseaseType);
    int update(DiseaseType diseaseType);

    List<DiseaseType> findalllist (Map<String,Object> map);

    Long getTotal(Map<String,Object> map);
    List<DiseaseType> searchdiseasetype(String userName);

    List<DiseaseType> findists();

    PageInfo<DiseaseType> finds(Params params);

    EUDataGridResult selectAll(int pageNum,int pageSize);
    DiseaseType testfindnull();
}
