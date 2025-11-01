package lotto.model

import lotto.Lotto
import lotto.constants.ErrorMessages
import lotto.constants.LottoConfig

data class BonusNumber(
    private val number: Int,
    private val winningLotto: Lotto
) {
    init {
        require(number in LottoConfig.MIN_NUMBER..LottoConfig.MAX_NUMBER) { ErrorMessages.BONUS_RANGE }
        require(!winningLotto.getNumbers().contains(number)) { ErrorMessages.BONUS_DUPLICATE }
    }

    fun getNumber() = number
}