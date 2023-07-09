package dev.glory.lecture.l01


fun main() {
    println("Hello World")

    // 변수 선언
    var number1 = 10
    number1 = 30

    // 불변 java final
    val number2 = 20
//    number2 = 40

    // 타입 명시 -> 초기화를 하지 않으면 타입을 추론할 수 없기에 타입을 명시해야 한다
    var number3: Int
    number3 = 30

    // boxing 과 unboxing 을 고려하지 않아도 된다. -> 자동으로 boxing 과 unboxing 이 된다.
    var number4: Long = 10L

    // kotlin 은 기본적으로 null 을 허용하지 않는다.
    // null 을 허용하려면 ? 를 붙여야 한다.
    var number5: Int? = null

    // new 키워드를 사용하지 않는다.
    var Person = Person("홍길동")
}
