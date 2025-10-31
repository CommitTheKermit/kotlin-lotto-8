package lotto.model

import lotto.Lotto

class WinningLotto(private val lotto : Lotto, private val bonusNumber : Int){
    init{
        require(bonusNumber in 1..45){"[ERROR] 보너스 번호는 1 이상 45 이하의 수여야 합니다."}
        require(!lotto.getNumbers().contains(bonusNumber)) {
            "[ERROR] 당첨 번호와 보너스 번호는 중복 될 수 없습니다."
        }
    }

    fun getLotto() = lotto

    fun getBonusNumber() = bonusNumber



}