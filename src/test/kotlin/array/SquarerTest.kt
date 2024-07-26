package array

import org.junit.jupiter.api.Test

class SquarerTest {

    @Test
    fun squaresOfSortedArrayWithoutNegatives() {
        assert(
            squaresOfSortedArray(intArrayOf(1, 2, 3, 4, 5)).contentEquals(
                intArrayOf(
                    1,
                    4,
                    9,
                    16,
                    25
                )
            )
        )
    }

    @Test
    fun squaresOfSortedArrayWithNegatives() {
        assert(
            squaresOfSortedArray(intArrayOf(-4, -1, 0, 3, 10)).contentEquals(
                intArrayOf(
                    0,
                    1,
                    9,
                    16,
                    100
                )
            )
        )
    }

    @Test
    fun squareOfSortedArraysWithSingleNegative() {
        assert(
            squaresOfSortedArray(intArrayOf(-1)).contentEquals(intArrayOf(1))
        )
    }

    @Test
    fun squareOfSortedArraysWithAllNegatives() {
        assert(
            squaresOfSortedArray(intArrayOf(-10, -5, -3, -2, -1)).contentEquals(
                intArrayOf(1, 4, 9, 25, 100)
            )
        )
    }
}