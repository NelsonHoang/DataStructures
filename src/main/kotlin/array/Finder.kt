package array

import java.util.SortedSet
import kotlin.math.abs

/**
 * Runtime: O(N)
 * Space Complexity: O(1) we don't count the list to return and do our logic
 * in place
 *
 * @param nums the original [IntArray]
 *
 * @return a [List] of numbers from the range 1 to n that do not appear in
 * [nums], n being the size of [nums]
 */
fun findDisappearedNumbers(nums: IntArray): List<Int> {
    for (num in nums) {
        if (nums[abs(num) - 1] < 0) continue
        nums[abs(num) - 1] *= -1
    }

    val list = mutableListOf<Int>()
    for (i in nums.indices) {
        if (nums[i] > 0) {
            list.add(i + 1)
        }
    }
    return list
}

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
