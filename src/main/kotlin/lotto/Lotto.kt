package lotto

import lotto.constants.ErrorMessages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessages.LOTTO_COUNT }
        require(numbers.distinct().size == 6) { ErrorMessages.LOTTO_DUPLICATE }
        require(numbers.sortedBy { it } == numbers) { ErrorMessages.LOTTO_ORDER }
        require(numbers.all { it in 1..45 }) { ErrorMessages.LOTTO_RANGE }
    }

    fun matchCount(other: Lotto): Int = numbers.count { it in other.getNumbers() }

    fun getNumbers(): List<Int> = numbers
}
