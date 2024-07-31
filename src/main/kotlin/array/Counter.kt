package array

/**
 * Runtime Complexity: O(N)
 *
 * Space Complexity: O(1)
 *
 * @param nums a binary [IntArray] consisting of only 1s and 0s
 *
 * @return the count of consecutive ones if a single
 */
fun checkConsecutiveOnesII(nums: IntArray): Int {
    var left = 0
    var right = 0
    var numberOfZeroes = 0
    var longestSequence = 0

    while (right < nums.size) {
        if (nums[right] == 0) numberOfZeroes++

        while (numberOfZeroes == 2) {
            if (nums[left] == 0) numberOfZeroes--
            left++
        }

        longestSequence = maxOf(longestSequence, right - left + 1)
        right++
    }

    return longestSequence
}

/**
 * Runtime Complexity: O(2^N) in the worst case we have an array with all 0s
 * and that would have a branching factor of 2.
 * Space Complexity: O(N) because the maximum depth of the recursion tree is N
 * @param nums a binary [IntArray] consisting of only 1s and 0s
 *
 * @return the count of consecutive ones if a single 0 is flipped into a 1
 */
fun checkConsecutiveOnesIIRecursion(nums: IntArray): Int {

    fun recurse(
        currentMax: Int,
        currentCount: Int,
        index: Int,
        hasFlippedZero: Boolean
    ): Int {
        if (index == nums.size) return currentMax

        if (nums[index] == 1) {
            val count = currentCount + 1
            val max = maxOf(currentMax, count)
            return recurse(max, count, index + 1, hasFlippedZero)
        }
        return if (hasFlippedZero) {
            recurse(currentMax, 0, index + 1, true)
        } else {
            val flippedCount = currentCount + 1
            val flippedMax = maxOf(currentMax, flippedCount)
            maxOf(
                recurse(
                    currentMax = flippedMax,
                    currentCount = flippedCount,
                    index = index + 1,
                    hasFlippedZero = true
                ),
                recurse(
                    currentMax = currentMax,
                    currentCount = 0,
                    index = index + 1,
                    hasFlippedZero = false
                )
            )
        }
    }

    return recurse(
        currentMax = 0,
        currentCount = 0,
        index = 0,
        hasFlippedZero = false
    )
}