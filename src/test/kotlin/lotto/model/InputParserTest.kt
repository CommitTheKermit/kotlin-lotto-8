package lotto.model

import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import lotto.parser.InputParser

class InputParserTest {
    @Test
    fun `쉼표로 구분된 입력을 정수 리스트로 반환`() {
        val result = InputParser.parseNumbers("1,2,3,4,5,6")
        assertThat(result).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `쉼표와 공백으로 구분된 문자열을 정수 리스트로 반환`() {
        val result = InputParser.parseNumbers("1, 2, 3, 4, 5, 6")
        assertThat(result).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `문자열에 정수가 아닌 문자가 있는 경우`() {
        assertThrows<IllegalArgumentException> {
            InputParser.parseNumbers("1,2,3,a,5,6")
        }
            }

    @Test
    fun `단일 문자열 반환`() {
        val result = InputParser.parseNumber("42")
        assertThat(result).isEqualTo(42)
    }

    @Test
    fun `정수가 아닌 단일 문자열`() {
        assertThrows<IllegalArgumentException> {
            InputParser.parseNumber("abc")
        }
    }

    @Test
    fun `단일 음수 문자열`() {
        val result = InputParser.parseNumber("-5")
        assertThat(result).isEqualTo(-5)
    }

    @Test
    fun `쉼표로 구분된 음수 문자열`() {
        val result = InputParser.parseNumbers("-1,-2,-3")
        assertThat(result).isEqualTo(listOf(-1, -2, -3))
    }
}