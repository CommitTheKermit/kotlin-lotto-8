package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.Lotto
import lotto.constants.ErrorMessages
import lotto.constants.LottoConfig

class User(private val money: Int) {
    private val lottos: List<Lotto>

    init {
        require(money > 0) { ErrorMessages.NOT_POSITIVE_PRICE }
        require(money % LottoConfig.PRICE == 0) { ErrorMessages.MONEY_UNIT }

        lottos = generateLottos()
    }

    fun generateLottos(): List<Lotto> {
        val count = money / LottoConfig.PRICE
        val lottos = List(count) {
            val numberList = pickUniqueNumbersInRange(
                LottoConfig.MIN_NUMBER, LottoConfig.MAX_NUMBER, LottoConfig.LOTTO_SIZE
            )
            Lotto(numberList)
        }

        return lottos
    }

    fun getLottos(): List<Lotto> = lottos

}