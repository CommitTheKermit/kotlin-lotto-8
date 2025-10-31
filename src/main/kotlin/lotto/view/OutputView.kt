package lotto.view

import lotto.model.LottoResult
import lotto.model.Prize
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

    fun showLottoStatistics(lottoStatistics: LottoResult) {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${lottoStatistics.getPrizeCount(Prize.FIFTH)}개")
        println("4개 일치 (50,000원) - ${lottoStatistics.getPrizeCount(Prize.FOURTH)}개")
        println("5개 일치 (1,500,000원) - ${lottoStatistics.getPrizeCount(Prize.THIRD)}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoStatistics.getPrizeCount(Prize.SECOND)}개")
        println("6개 일치 (2,000,000,000원) - ${lottoStatistics.getPrizeCount(Prize.FIRST)}개")
        println("총 수익률은 ${lottoStatistics.getProfitPercent()}%입니다.")
    }
}