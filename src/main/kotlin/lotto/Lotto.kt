package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 중복된 번호가 있습니다." }
        require(numbers.sortedBy { it } == numbers) { "[ERROR] 로또 번호는 오름차순이어야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1 이상 45 이하의 수여야 합니다." }
    }

    fun matchCount(other: Lotto): Int = numbers.count { it in other.getNumbers() }

    fun getNumbers(): List<Int> = numbers
}
