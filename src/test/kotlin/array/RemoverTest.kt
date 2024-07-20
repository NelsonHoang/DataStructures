package array

import org.junit.jupiter.api.Test

class RemoverTest {

    @Test
    fun removeElementWithManyOccurrences() {
        val array = intArrayOf(0,1,2,2,3,0,4,2)
        assert(removeElement(array, numToRemove = 2) == 5)
        val resultingArray = array.take(5).sorted().toIntArray()
        assert(resultingArray.contentEquals(intArrayOf(0,0,1,3,4)))
    }

    @Test
    fun removeElementWithNoOccurrences() {
        val array = intArrayOf(0,1,3,0,4)
        assert(removeElement(array, numToRemove = 2) == 5)
        assert(array.contentEquals(intArrayOf(0,1,3,0,4)))
    }

    @Test
    fun removeElementWithSingleElement() {
        val array = intArrayOf(1)
        assert(removeElement(array, numToRemove = 1) == 0)
    }
}