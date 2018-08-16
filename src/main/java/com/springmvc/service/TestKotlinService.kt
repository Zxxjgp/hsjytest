package com.springmvc.service

import com.springmvc.pojo.TestKotlin

/**
 *
 * @ProjectName:    hsjytest
 * @Package:        com.springmvc.service
 * @ClassName:      TestKotlinService
 * @Description:     java类作用描述
 * @Author:         焦关平
 * @CreateDate:     2018/7/30 8:52
 * @UpdateUser:     更新者
 * @UpdateDate:     2018/7/30 8:52
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
interface TestKotlinService {
    fun findAll() : List<TestKotlin>
}