package array

/**
 * @param nums the original [IntArray]
 *
 * @return an [IntArray] where all the even values are on the left side of
 * the array while the odd values are on the right side.
 */
fun sortArrayByParity(nums: IntArray): IntArray {
    var i = 0
    var j = nums.size - 1

    while (i < j) {
        if (nums[i] % 2 > nums[j] % 2) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        if (nums[i] % 2 == 0) i++
        if (nums[j] % 2 == 1) j--
    }
    return nums
}

/**
 * @param nums the original [IntArray]
 *
 * @param queue used to keep track off odd number indices and leads to
 * the algorithm having a Space complexity of O(N)
 *
 * @return an [IntArray] where all the even values are on the left side of
 * the array while the odd values are on the right side.
 */
fun sortArrayByParity(
    nums: IntArray,
    queue: ArrayDeque<Int>
): IntArray {
    nums.forEachIndexed { index, num ->
        if (num % 2 != 0) {
            queue.add(index)
        } else if (queue.isNotEmpty()) {
            val oddIndex = queue.removeFirst()
            val oddValue = nums[oddIndex]
            nums[oddIndex] = nums[index]
            nums[index] = oddValue
            queue.add(index)
        }
    }
    return nums
}