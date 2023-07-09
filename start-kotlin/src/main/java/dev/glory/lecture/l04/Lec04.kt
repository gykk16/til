package dev.glory.lecture.l04

fun main() {
    val money1 = Money(1000)
    val money2 = Money(1000)
    val money3 = money1

    if (money1 > money2) {
        println("money1 이 money2 보다 크다")
    } else {
        println("money1 이 money2 보다 작다")
    }

    println(money1 == money3)
    println(money1 == money2)
}