package com.springmvc.service;

import com.springmvc.pojo.RecruitRelationHospital;

import java.util.List;

public interface RecruitRelationHospitalService {
    int insert (RecruitRelationHospital recruitRelationHospital);
    List<RecruitRelationHospital> selectRelationHospital (String id);
}
