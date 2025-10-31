package lotto.controller

import lotto.model.User
import lotto.view.InputView
import lotto.view.OutputView

class LotteryController {
    fun run() {
        OutputView.showAmountInputGuide()
        val amount = InputView.readLine()

        val userLotto = User(amount.toInt())
        OutputView.showUserLottos(userLotto)
    }
}