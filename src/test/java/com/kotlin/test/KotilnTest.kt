package com.kotlin.test

import java.lang.Integer.parseInt

class Greeter{
    fun iter(vararg arg : Int){
        for(v in arg){
            print(v)
        }
    }

    fun greet() {
        println("Hello,")
    }
    fun sum(a: Int ,b: Int) : Int{
       return a + b;
    }
    fun prin(a: Int, b: Int) : Unit{
        println(a+ b)
    }
    /*边长参数*/
    fun vars(vararg v:Int){
        for(vt in v){
            print(vt)
        }
    }

    infix fun Int.add(x:Int) : Int{
        return this+x
    }

    fun gh(x: Int, y: Int ): Int = x + y

    fun parseI(str: String ?): Int  {
        var st = parseInt(str)
        return st
    }

    fun getStringLength(obj: Any): Int ? {
        if (obj is String) {
            // 做过类型判断以后，obj会被系统自动转换为String类型
            return obj.length
        }

        //在这里还有一种方法，与Java中instanceof不同，使用!is
        // if (obj !is String){
        //   // XXX
        // }

        // 这里的obj仍然是Any类型的引用
        return null
    }

    fun  div(n1 : Int, n2 : Int): Double ? {
        if (n2 == 0){
            return null
        }
        return n1.toDouble() / n2
    }
/*

    fun charintoint(c: Char): Int {
        if (c !in '0'..'2')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '0'.toInt() // 显式转换为数字
    }
*/

    fun compare(a: Int, b : Int) : Int{
    /*    val max = if (a > b) a else b   //比较大小*/

        val max = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }
        return max


    }
    fun whens(x: Int){
        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> { // 注意这个块
                print("x 不是 1 ，也不是 2")
            }
        }
    }


}

fun main(args: Array<String>) {
/*    Greeter().greet()
    // 创建一个对象不用 new 关键字
    Greeter().prin(11,12)
    println(Greeter().sum(5,6));*/
   /* Greeter().vars(5, 6, 45, 12, 3)*/



 /*   var mAccount = Person()
    mAccount.account = "秦川小将"
    mAccount.token = "0xbE803E33c0BBd4B672B97158cE21f80C0B6f3Aa6"
    println(mAccount.account)
    println(mAccount.token)*/

/*    val book = Books()
    val list = book.booksList
    for (gg in list){
        println(gg)
    }

    val b = Books.getDate();
    println("$b")*/
    /*
        val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
        println(sumLambda(1,2))  // 输出 3*/
/*    val sum = {a:Int, b: Int -> a + b }
    val gh : Int = 212
    println(gh)
    println(sum.toString())*/

/*    println(Greeter().gh(5, 6))
    val sum = { x: Int, y: Int -> x + y }
    println(sum(4,5))*/

/*    Greeter().iter(1,5,6,8,9,86,56)
    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
    println(sumLambda(5,6))*/

/*    var a = 1
    var b = 45
    val s1 = "a is $b"
    a = 2
    val s2 = "${s1.replace("is", "was")}${s1.substring(a)}, but now is $a"

    print(a*b)
    print(s2)*/
/*    var age : String ? = "23"
    var ages = age!!.toInt()
    val ages1 = age?.toInt()
    val ages2 = age?.toInt() ?: -1*/
    //print(ages2)
/*    var helloA: String ? = null
    val re = Greeter().parseI(null)*/
/*   println(Greeter().getStringLength("123wq"))

    val dicnumber = Greeter().div(10,0)
    var result = dicnumber!!.plus(100)
    print(result)*/
/*    for (i in 1..9 step 4) println(i)
    for (i in 1..9) print(i)*/
 //   for (i in 6 downTo 0 step 2) print(i) // 输出“42”

/*
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10//排除结束元素
        println(i)
    }*/

/*    val  a : Int = 100
    println(a === a)*/
/*    val a: Int = 1000
    val b: Int? = a
    val c: Int? = a
    println(b == c)    //true
    println(b === c)   //false*/
/*    val a: Int? = 1000
    val b: Int? = a
    val c: Int? = a
    println(b == c)    //true
    println(b === c)   //true*/
    /**
     * 注意查看===比较的是两个对象之间 ==是用来笔记哦啊数据之间的比较
     */

/*    var s : Int = 5

    print(++s)*/

    /**
     * 字符串的拼接工作
     */
/*    var char: String = "hello " + "world"
    var number: Int = 5
    print(char+number)*/
 //   println(Greeter().charintoint('2'))

/*
    val a = arrayOf(1, 2, 3)
    val b = Array(3,{i -> i*2})
    print(a[0])
    for (g in b){
        print(g)
    }
*/

    /**
     * 新建数组的两种方式
     */
/*    val shu1 = arrayOf("wqw","eqeqwe")
    val shu2 = Array(8,{i -> i })
    print(shu1.get(1).plus("你好啊这个是我追加的内容的"))
    print(shu1[1].capitalize())
    for (gg in shu2) print(gg)*/
/*    val  x: IntArray = intArrayOf(1, 2, 8)
    x[0] = x[1] + x[2]
    print(x[0])*/

/*    var  i =10;
    val s = "i == $i"
    val price = """
    $9.99
    """.trim()
    print(price)*/

  //  print(Greeter().compare(5,6))
   // Greeter().whens(9)
/*    var p = Person()
    p.name="qew"*/

/*    var x = 2
    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }

    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> { // 注意这个块
            println("x 不是 1 ，也不是 2")
        }
    }

    when (x) {
        in 0..10 -> println("x 在该区间范围内")
        else -> println("x 不在该区间范围内")
    }*/
/*    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }*/
/*    val s4="j"
    val s5="K"
    print(s4.compareTo(s5,ignoreCase = true))*/

  /*  val str ="There is a String accessing example"
    val substr = str.substring(29)
    println(substr)

    println(str.substring(11,17))*/

/*    var str: String = "789"
    val sub = StringBuilder() //初始容量为16
    println(sub.length)
    println(sub.capacity())*/

/*    val sub2 = StringBuilder("hello wordsd")
    sub2.append(555555555).append("\n").append('c').append("dwew")
    sub2.delete(1,2)
    sub2.replace(1,2,"前的")
    println(sub2)*/
}
