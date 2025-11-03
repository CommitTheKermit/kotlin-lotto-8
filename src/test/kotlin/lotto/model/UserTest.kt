package lotto.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class UserTest {
    @Test
    fun `1000원 단위가 아니면 예외`() {
        assertThrows<IllegalArgumentException> {
            User("1500")
        }
    }

    @Test
    fun `금액이 0보다 크지 않으면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            User("0")
        }
    }

    @Test
    fun `로또 개수 계산`() {
        val user = User("5000")
        assertThat(user.getLottos().size).isEqualTo(5)
    }
}
