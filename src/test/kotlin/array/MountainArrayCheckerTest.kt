package array

import org.junit.jupiter.api.Test

class MountainArrayCheckerTest {

    @Test
    fun checkIfMountainArrayTrue() {
        assert(checkIfMountainArray(intArrayOf(1,2,3,4,3,2,1)) == true)
    }

    @Test
    fun checkIfMountainArrayFalse() {
        assert(checkIfMountainArray(intArrayOf(1,3,3,4,3,6,1)) == false)
    }

    @Test
    fun checkIfMountainArraySingleElementFalse() {
        assert(checkIfMountainArray(intArrayOf(2)) == false)
    }
}