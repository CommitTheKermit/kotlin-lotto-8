package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.Lotto

class User(private val moneyInput: String) {
    private val lottos: List<Lotto>
    private val money: Int

    init {
        val testMoney = moneyInput.toIntOrNull()
        require(testMoney != null) { "[ERROR] 정수가 아닌 입력값입니다. " }
        require(testMoney % 1000 == 0) { "[ERROR] 로또 금액은 1000원 단위여야 합니다." }
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