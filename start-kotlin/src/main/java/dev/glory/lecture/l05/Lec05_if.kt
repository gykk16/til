package dev.glory.lecture.l05

fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("$score 점수는 음수가 될 수 없습니다.")
    }
}

fun requiredScoreIsNotNegative(score: Int) {
    require(score >= 0) { "$score 점수는 음수가 될 수 없습니다." }
}

fun passOrFail(score: Int): Boolean {
    // kotlin 에서는 if 문이 Expression 이기 때문에 return 에 사용할 수 있다.
    return if (score < 50) {
        false
    } else {
        true
    }
}

fun getGradeWithIf(score: Int): String {
    return if (score in 0..40) "F"
    else if (score in 41..70) "C"
    else if (score in 71..90) "B"
    else if (score in 91..100) "A"
    else "Unknown"
}

fun isValidScore(score: Int): Boolean {
    return score in 0..100
}