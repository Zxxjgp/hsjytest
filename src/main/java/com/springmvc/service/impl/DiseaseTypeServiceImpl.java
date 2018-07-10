package com.springmvc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.dao.DiseaseTypeDao;
import com.springmvc.pojo.DiseaseType;
import com.springmvc.service.DiseaseTypeService;
import com.springmvc.utils.EUDataGridResult;
import com.springmvc.utils.Params;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/***
 * @author XX
 * @date 2018.4.22
 * @version 1.0
 */
@Service
public class DiseaseTypeServiceImpl implements DiseaseTypeService {


    @Resource
    private DiseaseTypeDao diseaseTypeDao;

    @Override
    public List<DiseaseType> findAllList(DiseaseType entity) {
        return diseaseTypeDao.findAllList(entity);
    }

    @Override
    public int delestate(String id) {
        return diseaseTypeDao.delestate(id);
    }

    @Override
    public int add(DiseaseType diseaseType) {
        return diseaseTypeDao.insert(diseaseType);
    }

    @Override
    public int update(DiseaseType diseaseType) {
        return diseaseTypeDao.update(diseaseType);
    }

    @Override
    public List <DiseaseType> findalllist(Map<String, Object> map) {
        return diseaseTypeDao.findalllist(map);
    }

    @Override
    public Long getTotal(Map <String, Object> map) {
        return diseaseTypeDao.getTotal(map);
    }

    @Override
    public List <DiseaseType> searchdiseasetype(String userName) {
        return diseaseTypeDao.searchdiseasetype(userName);
    }

    @Override
    public List <DiseaseType> findists() {
        return diseaseTypeDao.findists();
    }

    @Override
    public PageInfo<DiseaseType> finds(Params params) {
        int pageNo = params.getPageNo();

        int pagePageNo = params.getPageSize();

        PageHelper.startPage(pageNo,pagePageNo);
        List<DiseaseType> diseaseTypeList = diseaseTypeDao.finds();
        PageInfo<DiseaseType> pageInfo = new PageInfo <DiseaseType>(diseaseTypeList);

        List<DiseaseType> diseaseTypeList1 = pageInfo.getList();
        return pageInfo;
    }

    @Override
    public EUDataGridResult selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<DiseaseType> list = diseaseTypeDao.findists();
        EUDataGridResult result = new EUDataGridResult();

         result.setRows(list);

        PageInfo<DiseaseType> pageInfo = new PageInfo <DiseaseType>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public DiseaseType testfindnull() {
        return diseaseTypeDao.testfindnull();
    }
}
