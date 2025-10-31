package lotto.model

import lotto.Lotto

class LottoMatcher(private val winningLotto : WinningLotto) {

    fun match(lottos : List<Lotto>): List<Prize> {
        val prizes =
        lottos.map { lotto ->
            getPrize(lotto)
            }
        return prizes
    }

    private fun getPrize(lotto: Lotto): Prize {
        val winningNumber = winningLotto.getLotto()
        val matchCount = winningNumber.matchCount(lotto)

        return when(matchCount) {
            6 -> Prize.FIRST
            5 -> matchBonusNumber(lotto)
            4 -> Prize.FOURTH
            3 -> Prize.FIFTH
            else -> Prize.NONE
        }
    }

    private fun matchBonusNumber(lotto : Lotto) : Prize{
        if(lotto.getNumbers().contains(winningLotto.getBonusNumber())){
            return Prize.SECOND
        }
        return Prize.THIRD
    }
}