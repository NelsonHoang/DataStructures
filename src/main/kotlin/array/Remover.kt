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

/**
 * @param nums a sorted [IntArray]
 *
 * @return the number of unique elements in [nums]
 */
fun removeDuplicatesFromSortedArray(nums : IntArray) : Int {
    if (nums.isEmpty()) return 0

    var current = nums[0]
    var uniqueNumbers = 1

    for (i in 1..<nums.size) {
        if (nums[i] != current) {
            current = nums[i]
            nums[uniqueNumbers] = current
            uniqueNumbers++
        }
    }

    return uniqueNumbers
}