package array

import java.util.SortedSet

/**
 *  Runtime Complexity: O(N) Since we scan the array once. Inserting to a
 *  [SortedSet] is O(Log N) time
 *  Space Complexity: O(1) Since our [SortedSet] is at most size 3
 *
 *  @return The value of the third max number in the array. If the third max
 *  number doesn't exist then return the max number
 */
fun findThirdMaxNumberWithSortedSet(nums: IntArray): Int {
    val sortedSet = sortedSetOf<Int>()

    for (num in nums) {
        if (sortedSet.contains(num)) continue
        if (sortedSet.size == 3) {
            if (sortedSet.first() < num) {
                sortedSet.pollFirst()
                sortedSet.add(num)
            }
        } else {
            sortedSet.add(num)
        }
    }

    return if (sortedSet.size == 3) {
        sortedSet.first()
    } else {
        sortedSet.last()
    }
}

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
