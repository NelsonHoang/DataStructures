package array

import org.junit.jupiter.api.Test

class CounterTest {
    @Test
    fun checkConsecutiveOnesIIRecursionOddArray() {
        assert(checkConsecutiveOnesIIRecursion(intArrayOf(1, 0, 1, 1, 0)) == 4)
    }

    @Test
    fun checkConsecutiveOnesIIRecursionEvenArray() {
        assert(checkConsecutiveOnesIIRecursion(intArrayOf(1, 1, 0, 1)) == 4)
    }

    @Test
    fun checkConsecutiveOnesIIRecursionAllZeroesArray() {
        assert(checkConsecutiveOnesIIRecursion(intArrayOf(0, 0, 0, 0)) == 1)
    }

    @Test
    fun checkConsecutiveOnesIIRecursionEndsWithOne() {
        assert(checkConsecutiveOnesIIRecursion(intArrayOf(0, 1, 0, 1)) == 3)
    }
}