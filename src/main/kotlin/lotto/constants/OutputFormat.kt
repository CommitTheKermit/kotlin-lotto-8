package lotto.constants

enum class OutputFormat(private val template: String, private val argCount : Int) {
    PURCHASED_COUNT("\n%d개를 구매했습니다.", 1),
    PLACE_COMMON("%d개 일치 (%,d원) - %d개", 3),
    PLACE_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", 3),
    PROFIT_PERCENT("총 수익률은 %,.1f%%입니다.", 1);

    fun format(vararg args: Any): String {
        require(argCount == args.size) { ErrorMessages.NOT_EQUAL_ARGUMENT_COUNT }

        return template.format(*args)
    }

}
