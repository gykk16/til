package dev.glory.lecture.l09

class Person(val name: String, var age: Int) {

    init {
        require(age >= 0) { "나이는 0보다 작을 수 없습니다." }
    }

    // 부 생성자
    constructor(name: String) : this(name, 0)

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

fun main() {
    val person = Person("홍길동")
    println(person)
}