package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.Lotto
import lotto.constants.ErrorMessages

class User(private val moneyInput: String) {
    private val lottos: List<Lotto>
    private val money: Int

    init {
        val testMoney = moneyInput.toIntOrNull()
        require(testMoney != null) { ErrorMessages.NOT_INTEGER }
        require(testMoney % 1000 == 0) { ErrorMessages.MONEY_UNIT }
        money = testMoney

        lottos = generateLottos()
    }

    fun generateLottos(): List<Lotto> {
        val count = money / 1000
        val lottos = List(count) {
            val numberList = pickUniqueNumbersInRange(1, 45, 6)
            numberList.sortBy { it }
            Lotto(numberList)
        }

        return lottos
    }

    fun getLottos(): List<Lotto> {
        return lottos
    }
}