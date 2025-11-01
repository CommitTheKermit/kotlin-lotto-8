package lotto.model

import lotto.Lotto

data class BonusNumber(
    private val number: Int,
    private val winningLotto: Lotto
) {
    init {
        require(number in 1..45) { "[ERROR] 보너스 번호는 1 이상 45 이하의 수여야 합니다." }
        require(!winningLotto.getNumbers().contains(number)) { "[ERROR] 당첨 번호와 보너스 번호는 중복 될 수 없습니다." }
    }

    fun getNumber() = number
}