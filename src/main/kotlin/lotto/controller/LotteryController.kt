package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.model.LottoMatcher
import lotto.model.LottoResult
import lotto.model.Prize
import lotto.model.User
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LotteryController {
    fun run() {
        val userLotto = generateUserLotto()

        val winningNumbers = readWinningNumber()
        val bonusNumber = readBonusNumber()

        val prizes = matchLotto(userLotto, winningNumbers, bonusNumber)

        showLottoResult(prizes)
    }

    fun generateUserLotto(): User {
        OutputView.showAmountInputGuide()
        val amount =  InputView.readLine()
        val userLotto = User(amount)
        OutputView.showUserLottos(userLotto)

        return userLotto
    }

    fun readWinningNumber() : List<String> {
        OutputView.showWinningLottoGuide()
        val winningNumbers = InputView.readLine().split(",")

        return winningNumbers
    }

    fun readBonusNumber() : Int {
        OutputView.showBonusNumberGuide()
        val bonusNumber = InputView.readLine().toInt()

        return bonusNumber
    }

    fun matchLotto(userLotto : User, winningNumbers : List<String>, bonusNumber :Int):List<Prize>{
        val winningLotto = WinningLotto(Lotto(winningNumbers.map { it.toInt() }), bonusNumber)
        val lottoMatcher = LottoMatcher(winningLotto)
        val prizes = lottoMatcher.match(userLotto.getLottos())

        return prizes
    }

    fun showLottoResult(prizes : List<Prize>) {
        val lottoStatistics = LottoResult(prizes)
        OutputView.showLottoStatistics(lottoStatistics)
    }
}