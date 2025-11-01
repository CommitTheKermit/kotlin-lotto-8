package lotto.view

import lotto.constants.Messages
import lotto.constants.OutputFormat
import lotto.model.LottoResult
import lotto.model.Prize
import lotto.model.User

object OutputView {
    fun showAmountInputGuide() {
        println(Messages.AMOUNT_INPUT_GUIDE)
    }

    fun showUserLottos(userLotto: User) {
        val lottos = userLotto.getLottos()
        println(OutputFormat.PURCHASED_COUNT.format(lottos.size))
        lottos.forEach {
            println("[" + it.getNumbers().joinToString(", ") + "]")
        }
    }

    fun showWinningLottoGuide() {
        println(Messages.WINNING_LOTTO_GUIDE)
    }

    fun showBonusNumberGuide() {
        println(Messages.BONUS_NUMBER_GUIDE)
    }

    fun showLottoStatistics(lottoStatistics: LottoResult) {
        println(Messages.STATISTICS_TITLE)
        println(Messages.STATISTICS_DIVIDER)

        val prizes = Prize.entries.filter { it != Prize.NONE }

        prizes.reversed().forEach {
            showPlace(it, lottoStatistics.getPrizeCount(it))
        }
        println(OutputFormat.PROFIT_PERCENT.format(lottoStatistics.getProfitPercent()))
    }

    private fun showPlace(prize: Prize, prizeCount: Int) {
        if (prize.bonusMatched) {
            println(OutputFormat.PLACE_BONUS.format(prize.matchCount, prize.prizeMoney, prizeCount))
            return
        }
        println(OutputFormat.PLACE_COMMON.format(prize.matchCount, prize.prizeMoney, prizeCount))
    }
}