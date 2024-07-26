package array

/**
 * @param nums array of [Int] sorted in increasing order
 *
 * @return [IntArray] of the squares of the original array in
 * increasing order
 */
fun squaresOfSortedArray(nums: IntArray): IntArray {
    val size = nums.size

    var left = 0
    var right = nums.size - 1
    val result = IntArray(size)

    var index = nums.size - 1
    while (left <= right) {
        if (nums[left] * nums[left] <= nums[right] * nums[right]) {
            result[index] = nums[right] * nums[right]
            right--
        } else {
            result[index] = nums[left] * nums[left]
            left++
        }
        index--
    }
    return result
}