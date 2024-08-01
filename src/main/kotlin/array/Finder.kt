package array

import java.util.PriorityQueue

/**
 * Runtime Complexity: O(N) since we scan the array once.
 * Space Complexity: O(1) since the set we use is limited to a size of 3.
 *
 * @param nums the original [IntArray]
 *
 * @return The value of the third max number in the array. If the third max
 * number doesn't exist then return the max number
 */
fun findThirdMaxNumber(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    var first: Int? = null
    var second: Int? = null
    var third: Int? = null
    for (num in nums) {
        if (set.contains(num)) continue

        if (first == null || num > first) {
            set.remove(third)
            set.add(num)
            third = second
            second = first
            first = num
        } else if (second == null || num > second) {
            set.remove(third)
            set.add(num)
            third = second
            second = num
        } else if (third == null || num > third) {
            set.remove(third)
            set.add(num)
            third = num
        }
    }

    return third ?: first ?: 0
}
