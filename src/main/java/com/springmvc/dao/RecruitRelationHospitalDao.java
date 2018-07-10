package com.springmvc.dao;

import com.springmvc.common.dao.CrudDao;
import com.springmvc.pojo.RecruitRelationHospital;

import java.util.List;

public interface RecruitRelationHospitalDao extends CrudDao<RecruitRelationHospital> {
    List<RecruitRelationHospital> selectRelationHospital (String id);
}
