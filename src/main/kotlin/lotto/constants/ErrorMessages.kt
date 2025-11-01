package lotto.constants

object ErrorMessages {
    const val LOTTO_COUNT = "[ERROR] 로또 번호는 6개여야 합니다."
    const val LOTTO_DUPLICATE = "[ERROR] 중복된 번호가 있습니다."
    const val LOTTO_ORDER = "[ERROR] 로또 번호는 오름차순이어야 합니다."
    const val LOTTO_RANGE = "[ERROR] 로또 번호는 1 이상 45 이하의 수여야 합니다."
    const val NOT_INTEGER = "[ERROR] 정수가 아닌 입력값입니다."
    const val MONEY_UNIT = "[ERROR] 로또 금액은 1000원 단위여야 합니다."
    const val BONUS_RANGE = "[ERROR] 보너스 번호는 1 이상 45 이하의 수여야 합니다."
    const val BONUS_DUPLICATE = "[ERROR] 당첨 번호와 보너스 번호는 중복 될 수 없습니다."
}
