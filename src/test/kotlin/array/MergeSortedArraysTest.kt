package array

import org.junit.jupiter.api.Test

class MergeSortedArraysTest {

    @Test
    fun mergeWithNonEmptyArrays() {
        assert(
            mergeSortedArrays(
                intArrayOf(1, 2, 3, 0, 0, 0),
                intArrayOf(2, 5, 6)
            ).contentEquals(
                intArrayOf(1, 2, 2, 3, 5, 6)
            )
        )
    }

    @Test
    fun mergeWithSecondEmptyArray() {
        assert(
            mergeSortedArrays(
                intArrayOf(1, 2, 3),
                intArrayOf()
            ).contentEquals(
                intArrayOf(1, 2, 3)
            )
        )
    }
}