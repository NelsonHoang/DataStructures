package array

import org.junit.jupiter.api.Test

class SorterTest {

    @Test
    fun sortArrayByParityOddSizedArray() {
        val array = sortArrayByParity(intArrayOf(3, 2, 1, 0, 4))
        assert(
            array.take(3).sorted().toIntArray()
                .contentEquals(intArrayOf(0, 2, 4))
        )
        assert(
            array.takeLast(2).sorted().toIntArray()
                .contentEquals(intArrayOf(1, 3))
        )
    }

    @Test
    fun sortArrayByParityEvenSizedArray() {
        val array = sortArrayByParity(intArrayOf(3, 2, 0, 4))
        assert(
            array.take(3).sorted().toIntArray()
                .contentEquals(intArrayOf(0, 2, 4))
        )
        assert(
            array.takeLast(1).sorted().toIntArray()
                .contentEquals(intArrayOf(3))
        )
    }

    @Test
    fun sortArrayByParityWithQueueOddSizedArray() {
        val array = sortArrayByParity(intArrayOf(3, 2, 1, 0, 4), ArrayDeque())
        assert(
            array.take(3).sorted().toIntArray()
                .contentEquals(intArrayOf(0, 2, 4))
        )
        assert(
            array.takeLast(2).sorted().toIntArray()
                .contentEquals(intArrayOf(1, 3))
        )
    }

    @Test
    fun sortArrayByParityWithQueueEvenSizedArray() {
        val array = sortArrayByParity(intArrayOf(3, 2, 0, 4), ArrayDeque())
        assert(
            array.take(3).sorted().toIntArray()
                .contentEquals(intArrayOf(0, 2, 4))
        )
        assert(
            array.takeLast(1).sorted().toIntArray()
                .contentEquals(intArrayOf(3))
        )
    }
}