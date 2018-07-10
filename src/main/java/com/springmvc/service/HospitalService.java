package com.springmvc.service;

import com.springmvc.pojo.Hospital;

import java.util.List;
import java.util.Map;
/**
 * @date 2018.4.22
 * @author jgp
 * @version 1.0
 *
 */
public interface HospitalService {
    List<Hospital> findlist(String id);
    int delestate(String id);
    List<Hospital> findalllist (Map<String,Object> map);

    Long getTotal(Map<String,Object> map);

    int add(Hospital hospital);
    int update(Hospital hospital);

    int delete(String id);
    List<Hospital> searchhospital(String userName);

    List<Hospital> findists();

}
