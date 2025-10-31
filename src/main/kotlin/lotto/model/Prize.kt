package lotto.model

enum class Prize(
    val matchCount: Int,
    val bonusMatched: Boolean,
    val prizeMoney: Long
) {
    FIRST(6, false, 2_000_000_000),      // 6개 일치
    SECOND(5, true, 30_000_000),          // 5개 + 보너스
    THIRD(5, false, 1_500_000),           // 5개
    FOURTH(4, false, 50_000),             // 4개
    FIFTH(3, false, 5_000),               // 3개
    NONE(0, false, 0);                    // 당첨 없음

    companion object {
        fun of(matchCount: Int, bonusMatched: Boolean): Prize {
            return entries.firstOrNull {
                it.matchCount == matchCount && it.bonusMatched == bonusMatched
            } ?: NONE
        }
    }
}