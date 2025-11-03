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
        return List(count) { createRandomLotto() }
    }

    private fun createRandomLotto(): Lotto {
        val numberList = pickUniqueNumbersInRange(
            LottoConfig.MIN_NUMBER, LottoConfig.MAX_NUMBER, LottoConfig.LOTTO_SIZE
        )
        return Lotto(numberList)
    }

    fun getLottos(): List<Lotto> = lottos

}