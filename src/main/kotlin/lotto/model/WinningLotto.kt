package lotto.model

import lotto.Lotto

class WinningLotto(private val lotto : Lotto, private val bonusNumber : BonusNumber){
    fun getLotto() = lotto

    fun getBonusNumber() = bonusNumber.getNumber()
}