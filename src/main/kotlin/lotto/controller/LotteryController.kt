package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

class LotteryController {
    fun run() {
        OutputView.showAmountInputGuide()
        val amount = InputView.readLine()

    }
}