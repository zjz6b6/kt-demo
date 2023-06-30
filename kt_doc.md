## Kotlin Lean

##### kotlin 对比 Java?

Kotlin是一种基于JVM的静态类型编程语言，它与Java具有很多相似之处，但也有一些不同之处。
相同点：

1. Kotlin和Java都是基于JVM的编程语言，可以在JVM上运行。
2. Kotlin和Java都是静态类型的编程语言，需要在编译时确定变量类型。
3. Kotlin和Java都支持面向对象编程和函数式编程。
    不同点：
4. Kotlin的语法更加简洁，可以减少代码量。
5. Kotlin支持空安全，可以避免空指针异常。
6. Kotlin支持扩展函数和属性，可以在不改变原有类的情况下添加新的函数和属性。
7. Kotlin支持lambda表达式，可以简化代码。
8. Kotlin支持协程，可以方便地实现异步编程。
9. Kotlin不需要使用分号来结束语句。
    总的来说，Kotlin比Java更加现代化和简洁，但它也有一些不兼容Java的特性。



##### kotlin大量使用inline，性能是否比Java优秀?

Kotlin中的`inline`关键字可以将函数的代码直接插入到调用它的地方，从而避免了函数调用的开销。这样可以提高程序的性能，特别是在一些需要频繁调用的场景下。
相比Java，Kotlin中的`inline`关键字确实可以提高程序的性能。因为在Java中，函数调用会涉及到函数栈的创建和销毁，会产生一定的开销。而在Kotlin中，使用`inline`关键字可以避免这些开销，从而提高程序的性能。
但是，需要注意的是，`inline`关键字并不是万能的，它也有一些限制。比如，不能将带有Lambda表达式参数的函数标记为`inline`，否则会导致生成的字节码变得非常庞大。此外，`inline`关键字还会增加编译时的开销，因为编译器需要将函数的代码插入到调用它的地方。
因此，虽然Kotlin中的`inline`关键字可以提高程序的性能，但在具体的应用场景中，需要根据实际情况来决定是否使用`inline`关键字。



##### 关键字

**public / protected / private / internal**
**expect / actual**
**final / open / abstract / sealed / const**
**external**
**override**
**lateinit**
**tailrec**
**vararg**
**suspend**
**inner**
**enum / annotation / fun // as a modifier in `fun interface`**
**companion**
**inline / value**
**infix**
**operator**
**data**



##### 基础语法

https://play.kotlinlang.org/byExample/overview



##### Spring整合

https://kotlinlang.org/docs/jvm-get-started-spring-boot.html

https://spring.io/guides/tutorials/spring-boot-kotlin/

https://spring.io/guides/tutorials/spring-webflux-kotlin-rsocket/



##### 扩展LLVM

以下是一些学习LLVM的课程推荐：

1. LLVM: A Compiler Infrastructure: 这是LLVM官方的入门课程，涵盖了LLVM项目的基础知识和核心概念。该课程包括讲座、实验和练习，适合初学者了解和掌握LLVM的基本原理和用法。
2. LLVM Compiler Optimization: 这是斯坦福大学的一门课程，重点介绍了LLVM优化器的工作原理和优化技术。学习者将通过实验和作业实践各种优化技术并了解它们的效果。
3. Advanced Compiler Optimizations: 这是康奈尔大学的一门高级编译器优化课程，其中涵盖了LLVM的一些高级优化技术，如循环优化、内存优化和代码生成等。学生将学习如何使用LLVM框架来实现和评估这些优化技术。
4. Compiler Construction using LLVM: 这是一门在Coursera平台上开设的课程，介绍了使用LLVM构建编译器的基本原理和技术。学生将学习如何使用LLVM的IR表示、优化技术和代码生成来构建一个完整的编译器。

除了这些课程，你也可以查阅LLVM官方网站上的文档，其中包含了丰富的教程、指南和示例，帮助你更深入地学习和理解LLVM的各个方面。此外，还可以参考一些开源项目或阅读一些相关的研究论文，以扩展你的LLVM知识。

有一些中文版的LLVM教程可以供您参考。以下是一些常见的中文版LLVM教程资源：

1. LLVM官方教程中文版：LLVM官方网站提供了一些中文翻译的LLVM教程，可以在官方网站上找到对应的中文版本。
2. 《LLVM源码剖析》：这是一本由清华大学出版社出版的中文书籍，作者对LLVM的源代码进行了全面的剖析和讲解，适合深入了解LLVM的内部原理和实现细节。
3. 《基于LLVM的编译器设计与实现》：这是一本由电子工业出版社出版的中文书籍，作者详细介绍了如何使用LLVM构建编译器，并介绍了LLVM的基本概念和使用方法。