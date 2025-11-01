package lotto.model

import lotto.Lotto
import lotto.constants.ErrorMessages

data class BonusNumber(
    private val number: Int,
    private val winningLotto: Lotto
) {
    init {
        require(number in 1..45) { ErrorMessages.BONUS_RANGE }
        require(!winningLotto.getNumbers().contains(number)) { ErrorMessages.BONUS_DUPLICATE }
    }

    fun getNumber() = number
}