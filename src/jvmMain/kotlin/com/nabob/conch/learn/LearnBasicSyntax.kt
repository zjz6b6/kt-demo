package com.github.zjz6b6.ideaplugindemo.learn

import io.github.oshai.kotlinlogging.KotlinLogging
import java.awt.Rectangle
import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths
import javax.swing.JButton

private val logger = KotlinLogging.logger {}

/**
 * public / protected / private / internal
 * expect / actual
 * final / open / abstract / sealed / const
 * external
 * override
 * lateinit
 * tailrec
 * vararg
 * suspend
 * inner
 * enum / annotation / fun // as a modifier in `fun interface`
 * companion
 * inline / value
 * infix
 * operator
 * data
 */

var a = 10
var b = 11

// 不可修改变量 final
val f = 10

// 常量
const val ff = 10

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
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

// 类型 判断 并自动 cast
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

fun demo(x: Any) {
    if (x is String) {
        print(x.length) // x is automatically cast to String
    }
}


// Lazy property
data class User(val id: Long, val username: String)

val user: User by lazy {  // the value is computed only on first access
    //can do other initialisation here
    User(id = 1001, username = "ballu")
}

// LazyThreadSafetyMode
val user1: User by lazy(LazyThreadSafetyMode.PUBLICATION) {
    //can do other initialisation here
    User(id = 1001, username = "ballu")
}

// 扩展函数 Extension functions 在不改变原有类的 情况下，扩展类
class Circle(val radius: Double) {
    fun area(): Double {
        return Math.PI * radius * radius;
    }
}

fun Circle.perimeter(): Double {
    return 2 * Math.PI * radius;
}
//var Circle.pie : Int
//    get() { return this.pie}
//    set(value) { this.pie = value }

// 单例 Create a singleton
object Resource {
    val name = "Name"
}

// 抽象类
abstract class MyAbstractClass() {

    abstract fun doSomething()
    abstract fun sleep()
}
// 主构造函数直接写class后面
class MyClass() :  MyAbstractClass() {

    init {
        println("init 构造函数调用的时候被调用")
    }

    override fun doSomething() {
        println("doSomething")
    }

    override fun sleep() {
        println("sleep")
    }
}


class Person {
    var name: String = ""
    var age: Int = 0
}
val p = Person()
open class Person2(var name: String, var age: Int) {
    init {
        println("inti")
    }
}
// 同时会调用父类的两参数构造函数
class Person3(name: String, age: Int) : Person2(name, age) {
    init {
        println("Person3 init")
    }

    constructor(name: String, age: Int, sex: String) : this(name, age) {

    }

    constructor(name: String, age: Int, sex: String, idCard: String) : this(name, age, sex) {

    }
}
class Person4 : Person2 {
    init {
        println("Person4 init")
    }

    constructor(name: String, age: Int) : super(name, age) {

    }

    constructor(name: String, age: Int, sex: String) : this(name, age) {

    }
}

// 半生对象
class StringUtils {
    companion object {
        fun isEmpty(str: String) : Boolean {
            return "" == str
        }
    }
}
// 单例
class Single private constructor() {
    companion object {
        fun get() : Single {
            return Holder.instance
        }

        private object Holder {
            val instance = Single()
        }
    }
}

fun main() {
    println("Hello World")

    println(sum(a, b))

    println(StringUtils.isEmpty("a"))

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
    for (i in 1..100) {
    }  // closed range: includes 100
    for (i in 1 until 100) {
    } // half-open range: does not include 100
    for (x in 2..10 step 2) {
    }
    for (x in 10 downTo 1) {
    }
    (1..10).forEach { }

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
    val aa = "Kotlin"
    val bb: String? = null
    println(bb?.length)
    println(aa?.length) // Unnecessary safe call

    val listWithNulls: List<String?> = listOf("Kotlin", null)
    listWithNulls.forEach { println(it) }
    for (item in listWithNulls) {
        // Execute if not null
        item?.let { println(it) } // prints Kotlin and ignores null
    }
    var filterNotNull = listWithNulls.filterNotNull()
    filterNotNull.forEach { println(it) }

    val person: LearnBasicSyntax? = null
    logger.debug("null person: ${person.toString()}") // Logs "null", does not throw an exception

    val l: Int = if (bb != null) bb.length else -1
    println(l)
    // ?: operator 的使用 - 左边非空，则返回左边，否则返回右边
    // If the expression to the left of ?: is not null, the Elvis operator returns it, otherwise it returns the expression to the right.
    val ll = bb?.length ?: -2
    println(ll)

    // !! operator 的使用  - 给null爱好者使用，如果被标识的对象是null，则抛异常
    // The third option is for NPE-lovers: the not-null assertion operator (!!) converts any value to a non-null type and throws an exception if the value is null
    try {
        val lll = bb!!.length
        println(lll)
    } catch (e: Exception) {
        println("lll error ${e.message}")
    }
//    var llll = bb.length  // 编译器报错

    // safe cast
    val sa = "1090";
    val sa1 = "试试";
//    val aInt0: Int? = sa as Int   // 报错
//    val aInt1: Int = sa as Int   // 报错
    val aInt2: Int? = sa as? Int
//    val aInt3: Int? = sa as Int?   // 报错
    val aInt4: Int? = sa1 as? Int
    println(aInt2)
    println(aInt4)

    val emails: List<String?> = listOf()
    val mainEmail = emails.firstOrNull() ?: "我是空的"
//    val mainEmail1 = emails.first() ?: "我是空的"  // 报错
    println("mainEmail: $mainEmail")

    val list = listOf("a", "b", "c")
    // todo 添加元素

    println("--------------------------------扩展函数-----------------------------------------------------------------")
    // 扩展函数 Extension functions 在不改变原有类的 情况下，扩展类
    val circle = Circle(5.5);
    val perimeterValue = circle.perimeter()
    println("Perimeter: $perimeterValue")
    val areaValue = circle.area()
    println("Area: $areaValue")
//    var pie = circle.pie
//    println("pie1: $pie")
//    circle.pie = 5
//    println("pie2: $pie")
//    println("pie3: ${circle.pie}")

    println("--------------------------------apply-----------------------------------------------------------------")
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }
    var arrayOfMinusOnes = arrayOfMinusOnes(2)
    arrayOfMinusOnes.forEach { println(it) }

    val myRectangle = Rectangle().apply {
        x = 4
        y = 5
    }

    println("--------------------------------with-----------------------------------------------------------------")
    // Call multiple methods on an object instance (with)
    /*
    class Turtle {
        fun penDown()
        fun penUp()
        fun turn(degrees: Double)
        fun forward(pixels: Double)
    }

    val myTurtle = Turtle()
    with(myTurtle) { //draw a 100 pix square
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
    */

    println("--------------------------------Files-----------------------------------------------------------------")
    val stream = Files.newInputStream(Paths.get("./README.md"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }

    // 交换值  Swap two variables
    var a = 1
    var b = 2
    a = b.also { b = a }
    println(a)
    println(b)

    println("--------------------------------TODO-----------------------------------------------------------------")
    fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")

    println("--------------------------------默认值-----------------------------------------------------------------")
    fun foo(a: String = "a") { /*...*/ }

    println("--------------------------------类型别名-----------------------------------------------------------------")
//    typealias MouseClickHandler = (Any, MouseEvent) -> Unit
//    typealias PersonIndex = Map<String, Person>

    println("--------------------------------Strings-----------------------------------------------------------------")
    println("""
    Not
    trimmed
    text
    """
    )

    println("""
    Trimmed
    text
    """.trimIndent()
    )

    println()

    val p = """Trimmed to margin text:
          |if(a > 1) {
          |    return a
          |}""".trimMargin()

    println(p)

    println("--------------------------------array-----------------------------------------------------------------")
    var emptyArray = emptyArray<JButton>()
    println(emptyArray.size)    // 0

    var arrayOfNulls = arrayOfNulls<JButton>(3)
    println(arrayOfNulls.size)    // 0
}
