package lotto

import lotto.model.BonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    @Test
    fun `유효한 보너스 번호로 생성된다`() {
        assertDoesNotThrow {
            BonusNumber(7, Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `보너스 번호가 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(46, Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `보너스 번호가 0 이하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(0, Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(6, Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }
}