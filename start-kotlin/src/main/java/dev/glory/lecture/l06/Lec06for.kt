package dev.glory.lecture.l06

fun main() {

    val list = listOf(1, 2, 3, 4, 5)

    // for each
    for (i in list) {
        println(i)
    }

    // for index
    println("withIndex")
    for (i in 0..3) {
        println(i)
    }

    println("downTo")
    for (i in 3 downTo 0) {
        println(i)
    }

    println("until")
    for (i in 0 until 3) {
        println(i)
    }

    println("step")
    for (i in 0..5 step 2) {
        println(i)
    }


}