package com.springmvc.pojo

/**
 *
 * @ProjectName:    hsjytest
 * @Package:        com.springmvc.pojo
 * @ClassName:      TestKotlin
 * @Description:     java类作用描述
 * @Author:         焦关平
 * @CreateDate:     2018/7/30 8:44
 * @UpdateUser:     更新者
 * @UpdateDate:     2018/7/30 8:44
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
data class TestKotlin ( var id : String ="2",
                   var username : String ="",

                   var password : String ="4")

fun String.todo() = this.trim()
fun Int.gg()= times(5)
fun Int.fg() = toString()



fun main(args: Array<String>) {
    var str= "  dfdsdffsd"
    var g = 56
    println(str.length)
    println(str.todo().length)

    var t = TestKotlin(username = "123")

    t.let {
        it.username=""
        str.let {
            it.apply {
                println(t)

            }
        }
    }
    println(t)
    println(g.gg())
    println(g.fg())
}