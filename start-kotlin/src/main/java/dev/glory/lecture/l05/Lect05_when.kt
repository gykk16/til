package dev.glory.lecture.l05

fun getGradeWithWhen(score: Int): String {
    return when (score) {
        in 0..40 -> "F"
        in 41..70 -> "C"
        in 71..90 -> "B"
        in 91..100 -> "A"
        else -> "Unknown"
    }
}

fun isValidScoreWithWhen(score: Int): Boolean {
    return when (score) {
        in 0..100 -> true
        else -> false
    }
}