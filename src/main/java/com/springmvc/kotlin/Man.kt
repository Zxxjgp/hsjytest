package com.springmvc.kotlin

/**
 *
 * @ProjectName:    hsjytest
 * @Package:        com.springmvc.kotlin
 * @ClassName:      Man
 * @Description:     java类作用描述
 * @Author:         焦关平
 * @CreateDate:     2018/8/17 10:38
 * @UpdateUser:     更新者
 * @UpdateDate:     2018/8/17 10:38
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
class Man(name : String) : Human(name) {
    override fun pee() {
        println("${name}站着尿尿")
    }
}