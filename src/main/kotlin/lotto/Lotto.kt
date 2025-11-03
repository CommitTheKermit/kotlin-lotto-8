package lotto

import lotto.constants.ErrorMessages
import lotto.constants.LottoConfig

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConfig.LOTTO_SIZE) { ErrorMessages.LOTTO_COUNT }
        require(numbers.distinct().size == LottoConfig.LOTTO_SIZE) { ErrorMessages.LOTTO_DUPLICATE }
        require(numbers.all { it in LottoConfig.MIN_NUMBER..LottoConfig.MAX_NUMBER }) { ErrorMessages.LOTTO_RANGE }
    }

    fun matchCount(other: Lotto): Int = numbers.count { it in other.getNumbers() }

    fun getNumbers(): List<Int> = numbers
}
