package array

import org.junit.jupiter.api.Test

class FinderTest {

    @Test
    fun findDisappearedNumbers() {
        val nums = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
        assert(
            findDisappearedNumbers(nums).toIntArray().contentEquals(
                intArrayOf(5, 6)
            )
        )
    }

    @Test
    fun findThirdMaxNumberSized() {
        val nums = intArrayOf(2, 4, 1, 3, 1)
        assert(findThirdMaxNumber(nums) == 2)
        assert(findThirdMaxNumberWithSortedSet(nums) == 2)
    }

    @Test
    fun findThirdMaxNumberSizedOneArray() {
        val nums = intArrayOf(2)
        assert(findThirdMaxNumber(nums) == 2)
        assert(findThirdMaxNumberWithSortedSet(nums) == 2)
    }

    @Test
    fun findThirdMaxNumberSizedTwoArray() {
        val nums = intArrayOf(2, 4)
        assert(findThirdMaxNumber(nums) == 4)
        assert(findThirdMaxNumberWithSortedSet(nums) == 4)
    }

    @Test
    fun findThirdMaxNumberSizedThreeArrayWithDupes() {
        val nums = intArrayOf(1, 1, 2)
        assert(findThirdMaxNumber(nums) == 2)
        assert(findThirdMaxNumberWithSortedSet(nums) == 2)
    }
}