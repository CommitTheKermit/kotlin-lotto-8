package lotto.view

import lotto.model.User


object OutputView {
    fun showAmountInputGuide(){
        println("구입금액을 입력해 주세요.")
    }

    fun showUserLottos(userLotto: User){
        val lottos = userLotto.getLottos()
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println("[" + it.getNumbers().joinToString ( ", ") + "]" )
        }
    }

    fun showWinningLottoGuide(){
        println("당첨 번호를 입력해 주세요.")
    }

    fun showBonusNumberGuide(){
        println("보너스 번호를 입력해 주세요.")
    }
}