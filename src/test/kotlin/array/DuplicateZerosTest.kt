package array

import org.junit.jupiter.api.Test

class DuplicateZerosTest {

    @Test
    fun duplicateZerosWithMixedNumbers() {
        assert(
            duplicateZeros(intArrayOf(0, 1, 2, 0, 4, 5)).contentEquals(
                intArrayOf(0, 0, 1, 2, 0, 0)
            )
        )
    }

    @Test
    fun duplicateZerosAllZero() {
        assert(
            duplicateZeros(intArrayOf(0, 0, 0, 0, 0, 0)).contentEquals(
                intArrayOf(0, 0, 0, 0, 0, 0)
            )
        )
    }
}