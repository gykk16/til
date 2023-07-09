package dev.glory.lecture.l02

fun main() {

}

fun startsWithA1(s: String?): Boolean {
    if (s == null) {
        throw IllegalArgumentException("s is null")
    }
    return s.startsWith("A")
}

fun startsWithA2(s: String?): Boolean? {
    if (s == null) {
        return null
    }
    return s.startsWith("A")
}

fun startsWithA3(s: String?): Boolean {
    // safe call
    return s?.startsWith("A") ?: false
}