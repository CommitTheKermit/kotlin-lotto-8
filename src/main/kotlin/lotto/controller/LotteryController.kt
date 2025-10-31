package lotto.controller

import lotto.Lotto
import lotto.model.LottoMatcher
import lotto.model.LottoResult
import lotto.model.User
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LotteryController {
    fun run() {
        OutputView.showAmountInputGuide()
        val amount = InputView.readLine()

        val userLotto = User(amount.toInt())
        OutputView.showUserLottos(userLotto)

        OutputView.showWinningLottoGuide()
        val winningNumbers = InputView.readLine().split(",")

        OutputView.showBonusNumberGuide()
        val bonusNumber = InputView.readLine().toInt()

        val winningLotto = WinningLotto(Lotto(winningNumbers.map { it.toInt() }), bonusNumber)

        val lottoMatcher = LottoMatcher(winningLotto)
        val prizes = lottoMatcher.match(userLotto.getLottos())

        val lottoStatistics = LottoResult(prizes)
        OutputView.showLottoStatistics(lottoStatistics)


    }
}