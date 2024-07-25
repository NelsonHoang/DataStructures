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
}