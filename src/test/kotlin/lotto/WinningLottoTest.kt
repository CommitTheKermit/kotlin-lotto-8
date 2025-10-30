package lotto

import lotto.model.WinningLotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class WinningLottoTest {
    @Test
    fun `정상 케이스`() {
        assertDoesNotThrow {
            WinningLotto(Lotto(listOf(1,2,3,4,5,6)), 7)
        }
    }
    @Test
    fun `당첨 번호는 6개이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1,2,3,4,5)), 7)
        }
    }

    @Test
    fun `당첨 번호는 1 ~ 45 범위 안에 속해야 한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(46,2,3,4,5,6)), 7)
        }
    }

    @Test
    fun `당첨 번호 간에 중복이 있으면 안된다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1,1,3,4,5,6)), 7)
        }
    }
}
