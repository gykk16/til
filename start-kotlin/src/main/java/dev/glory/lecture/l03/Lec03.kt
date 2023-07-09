package dev.glory.lecture.l03

fun main() {

    val number1 = 10
//    val number2: Long = number1
    val number2: Long = number1.toLong()

    val name = "홍길동"
    println("name: ${name}")
}

// Any -> java.lang.Object (null 제외)
// Any? -> java.lang.Object + null
// Unit -> void
// Nothing -> throw Exception