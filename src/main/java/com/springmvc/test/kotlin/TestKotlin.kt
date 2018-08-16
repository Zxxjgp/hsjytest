package com.springmvc.test.kotlin

import org.springframework.expression.OperatorOverloader

/**
 *
 * @ProjectName:    hsjytest
 * @Package:        com.springmvc.test.kotlin
 * @ClassName:      TestKotlin
 * @Description:     java类作用描述
 * @Author:         焦关平
 * @CreateDate:     2018/7/31 16:09
 * @UpdateUser:     更新者
 * @UpdateDate:     2018/7/31 16:09
 * @UpdateRemark:   更新说明
 * @Version:        1.0
 */
open class Person(var id : String ="" , var name: String ="", var age: Long = 0)

fun String.to()=this.trim()
/*
fun main(args:Array<String>){

    val  gt = Person()
    gt.let {
        person ->  println(person.age)
    }


    gt.apply {
        println(gt.name)
    }
    gt.run {

    }
    val a: Int = 999
    val b: Int? = a
    val c: Int? = a
    println(b == c)    //true
    println(b === c)
    var oo : OperatorOverride = OperatorOverride("zhang", 10)

    println("----------------------------------")

    println("原oo = ${oo}")
    +oo
    println("新oo = ${oo}")

    println("----------------------------------")

    println("----------------------------------")

    println("原oo = ${oo}")
    oo++
    println("新oo = ${oo}")

    println("----------------------------------")


    println("----------------------------------")
    val  o : OperatorOverride = OperatorOverride("zhao", 43)
    println("原oo = ${oo}")
    println("新oo = ${oo + o}")

    println("----------------------------------")

    println("----------------------------------")

    println(oo.equals(o)) // oo的age为120,o的age为43,故返回true

    println("----------------------------------")
}

data class OperatorOverride(var name: String, var age: Int) {
    // 重载 +a
    operator fun unaryPlus() : OperatorOverride{
        age = age.plus(100)
        return  this
    }

    // 重载 a++
    operator fun inc() : OperatorOverride {
        age += 10
        return  this
    }

    // 重载 a+b
    operator fun plus(oo: OperatorOverride): OperatorOverride {
        age += oo.age
        return  this
    }
    // 重载 equals
    override fun equals(other: Any?): Boolean {
        if (other is OperatorOverride) {
            return this.age > other.age
        }
        return false
    }
}*/

/*data class Incrby(var s : Int){

    operator fun unaryPlus() : Incrby{
        s = s.plus(100)
        return this
    }
}
data class Ifg(var s : Int){
    operator fun unaryPlus() : Ifg{
        s = s.plus(100)
        return this
    }
}

fun main(args: Array<String>){
    val o:Incrby = Incrby(50)
    val w : Ifg = Ifg(23)
    +o
    println("${o.s}")


}*/
data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}
fun wh(x : Int){
    when(x){
        1,5 -> print("x ==1")
        in 1..8 -> println("Nihao")
    }
}
fun hasPrefix(x : Any) =   when(x){
    is String -> x.startsWith("x")
    else -> false
}

fun main(args: Array<String>){
/*    var d : Int = 5
    var m : Int = 6
    println(d.plus(m))
    val plus = Counter(5).plus(10)
    println(plus)*/
/*
    var b : Int = 6
    var max = if (a > b ) a else b
    println(max)*/
/*    var  a: Int = 1
    wh(1)
    val hasPrefix= hasPrefix(789)

    println(hasPrefix)*/
// 不可变集合
/*    val mList: List<Int> = listOf(1, 3, 5, 7, 9)
// 调用toMutableList()函数进行转换
    val mMutableList = mList.toMutableList()
// 调用可变函数的add()方法
    mMutableList.add(11)
// 打印输出
    println(mMutableList)*/

    val mList: List<Int> = listOf(0, 1, 2, 3, 4, 5)
    val mIndex = mList.iterator()

    while (mIndex.hasNext()) {
        var str:Int = mIndex.next()
        if (str == 3){
            continue
        }
        println(str)
    }
/*    val mylist : List<Int> = listOf(0, 1, 2, 3, 4, 5,3,4)
    for (i in mylist.indices){
        println(mylist[i])
    }*/

}
