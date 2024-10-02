package io.glory.clazz.`object`

object StringUtils {

    fun String.removeSpaces(): String {
        return this.replace(" ", "")
    }

    fun String.removeSpaceAndHypen(): String {
        return this.replace(" ", "").replace("-", "")
    }
}

