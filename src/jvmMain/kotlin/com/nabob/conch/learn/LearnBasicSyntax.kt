package com.github.zjz6b6.ideaplugindemo.learn

var a = 10
var b = 11

// 不可修改变量 final
val f = 10

var s = "test string"

// null 指定
//var s1: String = null
var s2: String? = null

fun sum(aa: Int, bb: Int) = aa + bb

// String 模板
fun printLen(str: String): String {
    println("这是String: $str")
    return str
}

// List
val items = arrayListOf("apple", "banana", "potato", "orange")

// if
fun maxOf(x: Int, y: Int) = if (x > y) x else y

// when
fun descirbe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Hi"
        is Long -> "I am a Long"
        !is String -> "I am not a String"
        else -> "Unknown"
    }

fun descirbe2(x: Any) {
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> {
            println("x is neither 1 nor 2")
        }
    }
}

fun descirbe3(x: Any): String {
    return when (x) {
        1, 2 -> "x == 1 or x == 2"
        in 6..8 -> "6 <= x <= 8"
        else -> {
            "x is neither 1 nor 2 or in 6..8"
        }
    }
}

fun hasPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}

/**
 * when 语句块执行
 */
//fun Request.getBody() = when (val response = executeRequest()) {
//    is Success -> response.body
//    is HttpError -> throw HttpException(response.status)
//}

// 类 and 继承
open class Adam {
    var id: Int = 0
}

class LearnBasicSyntax(var name: String, var age: Int) : Adam() {

    var desc = "name: $name age: $age"

    fun incId() {
        this.id += 1
    }

}

// null support
fun parseInt(str: String): Int? {
    if (str.isBlank()) {
        return null;
    }
    return str.toInt()
}
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

fun main() {
    println("Hello World")

    println(sum(a, b))

    try {
        s = s2!!
    } catch (e: Exception) {
        println("null Error")
    }

//    f = 100

    printLen("来啦")

    val learnBasicSyntax = LearnBasicSyntax("Adam", 10)
    learnBasicSyntax.incId()
    println("${learnBasicSyntax.id} 用户 ${learnBasicSyntax.desc}")

//    items.forEach({ println(i) })

    // for
    for (item in items) {
        println(item)
    }
    for ((index, item) in items.withIndex()) {
        println("index：$index, item: $item")
    }
    for (index in items.indices) {
        println("index：$index, item: ${items[index]}")
    }

    // while
    var index = 0
    while (index < items.size) {
        println("index: $index, item: ${items[index]}")
        index++
    }

    // when
    println(descirbe(1))
    println(descirbe("Hello"))
    println(descirbe(2L))
    println(descirbe(2))
    println(descirbe("tt"))

    descirbe2(1)
    descirbe2(2)
    descirbe2(3)

    println(descirbe3(1))
    println(descirbe3(2))
    println(descirbe3(3))
    println(descirbe3(6))

    var toInt = "1".toInt()
    println("toInt: $toInt")

    println("-------------------------------------------------------------------------------------------------")
    for (x in 1..5) {
        print(x)
    }
    println()
    for (x in 1..10 step 2) { // 跨步
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }

    println("-------------------------------------------------------------------------------------------------")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    println("-------------------------------------------------------------------------------------------------")
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    // it 是固定的语法
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }

    println("--------------------------------null safe-----------------------------------------------------------------")
    printProduct("2", "5")

    // bob?.department?.head?.name
    val a = "Kotlin"
    val b: String? = null
    println(b?.length)
    println(a?.length) // Unnecessary safe call

    val listWithNulls: List<String?> = listOf("Kotlin", null)
    for (item in listWithNulls) {
        item?.let { println(it) } // prints Kotlin and ignores null
    }
}
