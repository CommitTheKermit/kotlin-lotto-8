package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 6개가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호가 1~45 범위를 벗어난 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 번호는 오른참순으로 정렬할 것`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(2, 1, 3, 4, 5, 6))
        }
    }

    @Test
    fun `한 로또와 다른 로또를 비교했을 때 일치 갯수를 반환`(){
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 7, 8, 9))
        assertThat(lotto1.matchCount(lotto2)).isEqualTo(3)
    }
}
