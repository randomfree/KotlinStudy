package com.example.ly.kotlinstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by txw_pc on 2017/5/18.
 * 注释跟java 一样的发现没
 */
class MActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        println(sum(1, 2))
        println(maxof(1, 2))
        useString()
        easyFor()
        rang(4,2)
        itfun()
    }

    fun sum(a: Int, b: Int) = a + b
    fun maxof(a: Int, b: Int) = if (a > b) a else b
    fun useString() {
        var a = 1//var 是变量
        //看样子在字符串中引用变量需要加$
        val s1 = "a is $a"//val 是常量
        a = 2
        //应该是如果需要引用变量同事调用方法的话就要${对象.方法}
        val s2 = "${s1.replace("is", "was")},but now is $a"
        println(s2)
    }

    fun getStringLength(obj: Any): Int? {// ?表示这个方法返回值可以null,如果没有?不能null报红
        if (obj is String && obj.length > 0) {//这个判断之后竟然可以直接调用String的方法了，if判断之前是不行的···这个有点智能啊··
            return obj.length
        }
        return null
    }

    /**
     * for 和 while
     */
    fun easyFor() {
        val items = listOf("aaa", "bbb", "ccc")
        for (item in items) {
            println(item)
        }
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }


        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }

    }

    /**
     * nb哄哄的switch
     *
     */
    fun nbswitch(obj: Any): String = when (obj) {
        1 -> "one"
        1,2 ->"1 or 2"
        "Hello" ->"is hello"
        is Long -> "is long"
        !is Long -> "not is long"

        else -> "unknow"

    }

    fun otherWhen(){
        val strs = setOf("apple","banana","kiwi")
        when{
            "apple" in strs -> println("apple nice")
            "banana" in strs -> println("banana is nice too")
        }
    }

    /**
     * 范围，表示一个东西是否在另一个的范围内
     */
    fun rang(i:Int):Boolean = i in 1..10

    //a瞎搞的为了重载一下
    fun rang(i:Int,a: Int){
        val x = 10
        val y = 9
        if (x in 1..y+1){
            println("yes")
        }
        val list = listOf<String>("ccc","ddd","eee")
        if (x !in 0..list.lastIndex){
            println("x out of rang")
        }
        if (list.size !in list.indices){
            println("list size is out of valid list indices rang too")
        }

        for (i in 1..5){
            println("for循环直接用rang什么意思====$i")
        }

        for (i in 1..5 step 2){//step2就是一次加2 i+=2的意思
            println("for循环直接用rang step 2 ====$i")
        }
        for (i in 9 downTo 0 step 3){//downTo 0 就是从9减到0 setp3就是i-=3
            println("for循环直接用rang downto 0 step 3 ====$i")
        }
    }

    fun itfun(){
        val fruits = listOf("abb","bbb","ccc","aaa")
        fruits.filter { it.startsWith("a") }//过滤出以a开头的元素
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach{ println(it)}
    }


}