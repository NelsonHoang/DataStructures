package array

/**
 * @param [nums] the original [IntArray]
 * @param [numToRemove] the number to remove in the original array
 *
 * @return the number of elements remaining after we removed [numToRemove]
 */
fun removeElement(nums: IntArray, numToRemove: Int): Int {
    var k = 0

    for (i in nums.indices) {
        if (nums[i] != numToRemove) {
            nums[k] = nums[i]
            k++
        }
    }
    return k
}