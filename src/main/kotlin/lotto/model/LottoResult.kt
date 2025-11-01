package lotto.model

class LottoResult(private val prizes: List<Prize>) {
    private val prizeCount: Map<Prize, Int>
    private val profitSum: Long
    private val profitPercent: Double

    init {
        val prizeGroup = prizes.groupBy { it }
        prizeCount = prizeGroup.mapValues { it.value.size }

        profitSum = prizes.sumOf { it.prizeMoney }

        profitPercent = (profitSum / (prizes.size * 1000.0)) * 100.0
    }

    fun getPrizeCount(prize: Prize): Int = prizeCount[prize] ?: 0

    fun getAmountSum(): Long = profitSum

    fun getProfitPercent(): Double = profitPercent

}
