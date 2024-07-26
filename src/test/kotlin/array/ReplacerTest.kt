package array

import org.junit.jupiter.api.Test

class ReplacerTest {

    @Test
    fun replaceElementsWithGreatestElementOnRightSide() {
        assert(
            replaceElementsWithGreatestElementOnRightSide(
                intArrayOf(
                    17,
                    18,
                    5,
                    4,
                    6,
                    1
                )
            ).contentEquals(intArrayOf(18, 6, 6, 6, 1, -1))
        )
    }

    @Test
    fun moveZeroesToEndWithZeroes() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        moveZeroesToEnd(nums)
        assert(nums.contentEquals(intArrayOf(1, 3, 12, 0, 0)))
    }

    @Test
    fun moveZeroesToEndWithNoZeroes() {
        val nums = intArrayOf(2, 1, 4, 3, 12)
        moveZeroesToEnd(nums)
        assert(nums.contentEquals(intArrayOf(2, 1, 4, 3, 12)))
    }
}