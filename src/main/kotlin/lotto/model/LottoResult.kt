package lotto.model

import lotto.constants.LottoConfig
import java.math.RoundingMode

class LottoResult(private val prizes: List<Prize>) {
    private val prizeCount: Map<Prize, Int>
    private val profitSum: Long
    private val profitPercent: Double

    init {
        val prizeGroup = prizes.groupBy { it }
        prizeCount = prizeGroup.mapValues { it.value.size }

        profitSum = prizes.sumOf { it.prizeMoney }

        val originalPercent = (profitSum * 100.0 / (prizes.size * LottoConfig.PRICE))
        val roundPercent = originalPercent.toBigDecimal()
        profitPercent = roundPercent.setScale(1, RoundingMode.HALF_UP).toDouble()
    }

    fun getPrizeCount(prize: Prize): Int = prizeCount[prize] ?: 0

    fun getAmountSum(): Long = profitSum

    fun getProfitPercent(): Double = profitPercent

}
