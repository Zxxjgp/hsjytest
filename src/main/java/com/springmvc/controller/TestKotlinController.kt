package com.springmvc.controller

import com.springmvc.exception.auth.AuthException
import com.springmvc.pojo.TestKotlin
import com.springmvc.service.TestKotlinService
import org.omg.CORBA.Object
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @ProjectName:    hsjytest
 * @Package:        com.springmvc.controller
 * @ClassName:      TestKotlinController
 * @Description:     java类作用描述
 * @Author:         焦关平
 * @CreateDate:     2018/7/30 8:57
 * @UpdateUser:     更新者
 * @UpdateDate:     2018/7/30 8:57
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
@RestController
@RequestMapping("ko")
class TestKotlinController {
    @Autowired
    private lateinit var testKotlinService: TestKotlinService

    @RequestMapping("tlin")
    fun getAll(): List<TestKotlin> ? = testKotlinService.findAll()

    @RequestMapping("exception")
    fun  excepetionTest() : Object{
        throw AuthException("这个是错误的不要香型我")
    }
}