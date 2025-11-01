package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `등수별 당첨 개수 집계`() {
        val result = LottoResult(
            listOf(Prize.FIRST, Prize.FIRST, Prize.THIRD, Prize.THIRD, Prize.THIRD, Prize.NONE)
        )

        assertThat(result.getPrizeCount(Prize.FIRST)).isEqualTo(2)
        assertThat(result.getPrizeCount(Prize.THIRD)).isEqualTo(3)
        assertThat(result.getPrizeCount(Prize.NONE)).isEqualTo(1)
        assertThat(result.getPrizeCount(Prize.SECOND)).isEqualTo(0)
    }

    @Test
    fun `단일 상금 계산`() {
        val result = LottoResult(listOf(Prize.FIRST))

        assertThat(result.getAmountSum()).isEqualTo(Prize.FIRST.prizeMoney)
    }

    @Test
    fun `전체 상금 계산`() {
        val result = LottoResult(
            listOf(Prize.FIRST, Prize.SECOND, Prize.THIRD, Prize.FOURTH, Prize.FIFTH, Prize.NONE)
        )
        val expectedSum = Prize.FIRST.prizeMoney + Prize.SECOND.prizeMoney + Prize.THIRD.prizeMoney + Prize.FOURTH.prizeMoney + Prize.FIFTH.prizeMoney

        assertThat(result.getAmountSum()).isEqualTo(expectedSum)
    }

    @Test
    fun `전체 상금 계산 - 여러 로또 당첨`() {
        val result = LottoResult(
            listOf(Prize.FIRST, Prize.FIRST, Prize.THIRD, Prize.THIRD)
        )
        val expectedSum = (Prize.FIRST.prizeMoney * 2) + (Prize.THIRD.prizeMoney * 2)

        assertThat(result.getAmountSum()).isEqualTo(expectedSum)
    }

    @Test
    fun `수익률 계산, 낙첨만 있을 때`() {
        val result = LottoResult(
            listOf(Prize.NONE, Prize.NONE)
        )

        assertThat(result.getProfitPercent()).isEqualTo(0.0)
    }

    @Test
    fun `수익률 계산, 5등 당첨`() {
        val result = LottoResult(
            listOf(Prize.FIFTH, Prize.NONE, Prize.NONE, Prize.NONE, Prize.NONE, Prize.NONE, Prize.NONE ,Prize.NONE)
        )

        assertThat(result.getProfitPercent()).isEqualTo(62.5)
    }
}
