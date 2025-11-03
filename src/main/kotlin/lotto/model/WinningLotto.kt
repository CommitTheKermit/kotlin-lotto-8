package lotto.model

import lotto.Lotto

data class WinningLotto(private val lotto : Lotto, private val bonusNumber : BonusNumber){
    fun getLotto() = lotto

    fun getBonusNumber() = bonusNumber.getNumber()
}