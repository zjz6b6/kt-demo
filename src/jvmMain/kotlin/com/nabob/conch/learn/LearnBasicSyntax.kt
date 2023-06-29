package com.github.zjz6b6.ideaplugindemo.learn

class LearnBasicSyntax {

}

var a = 10
var b = 11

// 不可修改变量 final
val f = 10

var s = "test string"

// null 指定
//var s1: String = null
var s2: String? = null

fun sum(aa: Int, bb: Int) = aa + bb

// 模板
fun printLen(str: String): String {
    println("这是String: $str")
    return str
}

fun main() {
    println("Hello World")

    println(sum(a, b))

    try {
        s = s2!!
    } catch (e: Exception) {
        println("null Error")
    }

    printLen("来啦")
}
