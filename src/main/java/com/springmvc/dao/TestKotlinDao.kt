package com.springmvc.dao

import com.springmvc.pojo.TestKotlin

/**
 *
 * @ProjectName:    hsjytest
 * @Package:        com.springmvc.dao
 * @ClassName:      TestKotlinDao
 * @Description:     java类作用描述
 * @Author:         焦关平
 * @CreateDate:     2018/7/30 8:42
 * @UpdateUser:     更新者
 * @UpdateDate:     2018/7/30 8:42
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
interface TestKotlinDao {
    fun findAll() : List<TestKotlin>
}