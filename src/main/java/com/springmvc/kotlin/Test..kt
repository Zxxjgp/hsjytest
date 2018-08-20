@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.springmvc.kotlin

/**
 *
 * @ProjectName:    hsjytest
 * @Package:        com.springmvc.kotlin
 * @ClassName:      `Test.`
 * @Description:     java类作用描述
 * @Author:         焦关平
 * @CreateDate:     2018/8/16 18:58
 * @UpdateUser:     更新者
 * @UpdateDate:     2018/8/16 18:58
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
fun diary(placeName : String){
    var dir = """ 今天天气晴朗，蔚蓝的天空万里无云。诺宝这么早就去${placeName}啦,门上有${zhuanChinese(placeName.length)}大字"""
    println(dir)
}

fun zhuanChinese(num : Int):String{
    var tem = when(num){
        1 -> "一"
        2 -> "二"
        3 -> "三"
        4 -> "四"
        5 -> "五"
        else -> "地名太长了"
    }

    return  tem
}
fun gt(){

}
/*fun main(args: Array<String>) {
    diary("太湖公园爱爱说的")
    var nums = 1 .. 100 //这个是闭区间 [1 100]
    var k = 1 until  100 // [1 100)
    var g =k.reversed()
    for (a in g step 2) println(a)


    println(k)
    var m = 0
    for (nu in nums){
        m += nu
    }
    println(m)
}*/
//list和map
/*fun main(args: Array<String>) {
    var list = listOf("卖鸡蛋","卖大米","麦度李四","买冰淇淋")
    println(list.size)
    for ( (e,i) in list.withIndex()){
        println("$e $i")
    }
    var map = HashMap<String,String>()
    map["好"] = "good"
    map["很好"] = "very good"
    println(map["好"])
    println(add(2,5))
        var i = {x: Int ,y : Int -> x+y}
    println(i(1,2))

    var j:(Int,Int) -> Int = {x, y -> x+y}
    println(j(1,3))
    println(获取长方形的吗面积(5,3))
}*/

fun add(x: Int, y:Int) : Int = x+y

fun 获取长方形的吗面积(长: Int, 宽: Int): Int = 长*宽
class React(var with: Int, var height: Int)

/*fun main(args: Array<String>) {
    *//*val react = React(5, 6)
    println("${react.height}")*//*
*//*    val son = Son();
    println(son.chartet)
    son.action()*//*
    var person1 = Man("金三胖")
    var person2 = Women("慈禧太后")
    var person3 = Man("小花花")
    var person4 = Women("大花花")
    var list = listOf<Human>(person1,person2,person3,person4)
    for (li in list) li.pee()
}*/

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    Derived(b).print()
    var aa: Short = 1000
    var bb = Integer.valueOf(aa.toInt())
    var cc = Integer.valueOf(aa.toInt())
    println(bb == cc)
    println(bb === cc)
    println(bb.equals(cc))
}