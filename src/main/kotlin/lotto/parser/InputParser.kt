package lotto.parser

import lotto.constants.ErrorMessages

object InputParser {
    fun parseNumbers(input: String): List<Int> {
        val parsed = input.split(",").map {
            parseNumber(it)
        }

        return parsed
    }

    fun parseNumber(input: String): Int {
        val parsed = input.trim()
        require(parsed.isNotEmpty() ) { ErrorMessages.NOT_EMPTY }
        require(parsed.toIntOrNull() != null) { ErrorMessages.NOT_INTEGER }

        return parsed.toInt()
    }
}
