package lotto.constants

enum class OutputFormat(private val format: String) {
    PURCHASED_COUNT("\n%d개를 구매했습니다."),
    FIFTH_PLACE("3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE("4개 일치 (50,000원) - %d개"),
    THIRD_PLACE("5개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - %d개"),
    PROFIT_PERCENT("총 수익률은 %,.1f%%입니다.");

    fun format(arg: Any): String = format.format(arg)
}
