package lotto.model

import lotto.Lotto

class LottoMatcher(private val winningLotto: WinningLotto) {

    fun match(lottos: List<Lotto>): List<Prize> {
        val prizes =
            lottos.map { lotto ->
                getPrize(lotto)
            }
        return prizes
    }

    private fun getPrize(lotto: Lotto): Prize {
        val winningNumber = winningLotto.getLotto()
        val matchCount = winningNumber.matchCount(lotto)
        val isBonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber())

        return Prize.of(matchCount, isBonusMatch)
    }
}