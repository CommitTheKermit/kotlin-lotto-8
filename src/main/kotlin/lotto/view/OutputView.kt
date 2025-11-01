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
        println(OutputFormat.FIFTH_PLACE.format(lottoStatistics.getPrizeCount(Prize.FIFTH)))
        println(OutputFormat.FOURTH_PLACE.format(lottoStatistics.getPrizeCount(Prize.FOURTH)))
        println(OutputFormat.THIRD_PLACE.format(lottoStatistics.getPrizeCount(Prize.THIRD)))
        println(OutputFormat.SECOND_PLACE.format(lottoStatistics.getPrizeCount(Prize.SECOND)))
        println(OutputFormat.FIRST_PLACE.format(lottoStatistics.getPrizeCount(Prize.FIRST)))
        println(OutputFormat.PROFIT_PERCENT.format(lottoStatistics.getProfitPercent()))
    }
}