package array

import org.junit.jupiter.api.Test

class SearchTest {

    @Test
    fun checkIfNAndDoubleExistsTrue() {
        assert(checkIfNAndDoubleExists(intArrayOf(1, 5, 10, 3)) == true)
    }

    @Test
    fun checkIfNAndDoubleExistsWithNegativesTrue() {
        assert(checkIfNAndDoubleExists(intArrayOf(-2,0,10,-19,4,6,-8)) == false)
    }

    @Test
    fun checkIfNAndDoubleExistsFalse() {
        assert(checkIfNAndDoubleExists(intArrayOf(1, 5, 15, 21)) == false)
    }
}