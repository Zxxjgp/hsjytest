package com.springmvc.service.impl;

import com.springmvc.dao.RecruitRelationHospitalDao;
import com.springmvc.pojo.RecruitRelationHospital;
import com.springmvc.service.RecruitRelationHospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecruitRelationHospitalServiceImpl implements RecruitRelationHospitalService {

    @Resource
    private RecruitRelationHospitalDao recruitRelationHospitalDao;
    @Override
    public int insert(RecruitRelationHospital recruitRelationHospital) {
        return recruitRelationHospitalDao.insert(recruitRelationHospital);
    }

    @Override
    public List<RecruitRelationHospital> selectRelationHospital(String id) {
        return recruitRelationHospitalDao.selectRelationHospital(id);
    }
}
