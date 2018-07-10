package com.springmvc.service;

import com.springmvc.pojo.ProjectResruit;

import java.util.List;

/**
 * @date 2018.4.22
 * @author jgp
 */
public interface ResruitService {
    List<ProjectResruit> findAllList(ProjectResruit entity);
}
