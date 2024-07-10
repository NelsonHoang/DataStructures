package array

import org.junit.jupiter.api.Test

class BinarySearchTest {
    @Test
    fun binarySearchOddSizedArray() {
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5), 1) == 0)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5), 2) == 1)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5), 3) == 2)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5), 4) == 3)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5), 5) == 4)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5), 6) == -1)
    }

    @Test
    fun binarySearchEvenSizedArray() {
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 1) == 0)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 2) == 1)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 3) == 2)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 4) == 3)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 5) == 4)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 6) == 5)
        assert(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 7) == -1)
    }
}