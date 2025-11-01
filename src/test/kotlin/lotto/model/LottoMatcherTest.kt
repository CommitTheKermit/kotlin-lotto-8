package lotto.model

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMatcherTest {
    @Test
    fun `1등의 경우`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningLotto)

        assertThat(
            LottoMatcher(WinningLotto(winningLotto, bonusNumber)).match(
                listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
            )
        ).isEqualTo(listOf(Prize.FIRST))
    }

    @Test
    fun `2등의 경우`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningLotto)

        assertThat(
            LottoMatcher(WinningLotto(winningLotto, bonusNumber)).match(
                listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
            )
        ).isEqualTo(listOf(Prize.SECOND))
    }

    @Test
    fun `3등의 경우`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningLotto)

        assertThat(
            LottoMatcher(WinningLotto(winningLotto, bonusNumber)).match(
                listOf(Lotto(listOf(1, 2, 3, 4, 5, 8)))
            )
        ).isEqualTo(listOf(Prize.THIRD))
    }

    @Test
    fun `4등의 경우`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningLotto)

        assertThat(
            LottoMatcher(WinningLotto(winningLotto, bonusNumber)).match(
                listOf(Lotto(listOf(1, 2, 3, 4, 7, 8)))
            )
        ).isEqualTo(listOf(Prize.FOURTH))
    }

    @Test
    fun `5등의 경우`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningLotto)

        assertThat(
            LottoMatcher(WinningLotto(winningLotto, bonusNumber)).match(
                listOf(Lotto(listOf(1, 2, 3, 7, 8, 9)))
            )
        ).isEqualTo(listOf(Prize.FIFTH))
    }

    @Test
    fun `낙첨`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningLotto)

        assertThat(
            LottoMatcher(WinningLotto(winningLotto, bonusNumber)).match(
                listOf(Lotto(listOf(7, 8, 9, 10, 11, 12)))
            )
        ).isEqualTo(listOf(Prize.NONE))
    }
}
