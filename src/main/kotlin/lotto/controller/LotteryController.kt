package lotto.controller

import lotto.Lotto
import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView

class LotteryController {
    fun run() {
        val userLotto = generateUserLotto()

        val winningLotto = readWinningLotto()
        val bonusNumber = readBonusNumber(winningLotto)

        val prizes = matchLotto(userLotto, WinningLotto(winningLotto, bonusNumber))

        showLottoResult(prizes)
    }

    fun generateUserLotto(): User {
        while (true) {
            try {
                OutputView.showAmountInputGuide()
                val amount = InputView.readLine()
                val userLotto = User(amount)
                OutputView.showUserLottos(userLotto)
                return userLotto
            } catch (e: IllegalArgumentException) {
                OutputView.showError(e.message ?: "")
            }
        }
    }

    fun readWinningLotto(): Lotto {
        while (true) {
            try {
                OutputView.showWinningLottoGuide()
                val winningNumbers = InputView.readLine().split(",").map { it.toInt() }
                return Lotto(winningNumbers)
            } catch (e: IllegalArgumentException) {
                OutputView.showError(e.message ?: "")
            }
        }
    }

    fun readBonusNumber(winningLotto: Lotto): BonusNumber {
        while (true) {
            try {
                OutputView.showBonusNumberGuide()
                val bonusNumber = InputView.readLine().toInt()
                return BonusNumber(bonusNumber, winningLotto)
            } catch (e: IllegalArgumentException) {
                OutputView.showError(e.message ?: "")
            }
        }
    }

    fun matchLotto(userLotto: User, winningLotto: WinningLotto): List<Prize> =
        LottoMatcher(winningLotto).match(userLotto.getLottos())

    fun showLottoResult(prizes: List<Prize>) {
        val lottoStatistics = LottoResult(prizes)
        OutputView.showLottoStatistics(lottoStatistics)
    }
}