package com.springmvc.service.impl

import com.springmvc.dao.TestKotlinDao
import com.springmvc.pojo.TestKotlin
import com.springmvc.service.TestKotlinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * @ProjectName:    hsjytest
 * @Package:        com.springmvc.service.impl
 * @ClassName:      TestKotlinServiceImpl
 * @Description:     java类作用描述
 * @Author:         焦关平
 * @CreateDate:     2018/7/30 8:53
 * @UpdateUser:     更新者
 * @UpdateDate:     2018/7/30 8:53
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */

@Service
class TestKotlinServiceImpl : TestKotlinService {
    @Autowired
    private lateinit var testKotlinDao : TestKotlinDao
    override fun findAll(): List<TestKotlin> {
        return testKotlinDao.findAll()
    }
}