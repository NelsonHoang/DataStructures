package array

import org.junit.jupiter.api.Test

class FinderTest {

    @Test
    fun findThirdMaxNumberSized() {
        assert(findThirdMaxNumber(intArrayOf(2, 4, 1, 3, 1)) == 2)
    }

    @Test
    fun findThirdMaxNumberSizedOneArray() {
        assert(findThirdMaxNumber(intArrayOf(2)) == 2)
    }

    @Test
    fun findThirdMaxNumberSizedTwoArray() {
        assert(findThirdMaxNumber(intArrayOf(2, 4)) == 4)
    }

    @Test
    fun findThirdMaxNumberSizedThreeArrayWithDupes() {
        assert(findThirdMaxNumber(intArrayOf(1, 1, 2)) == 2)
    }
}