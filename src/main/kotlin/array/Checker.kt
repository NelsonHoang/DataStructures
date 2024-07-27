package array

/**
 * @param arr the original array
 *
 * @return true if [arr] is a mountain array defined values that initially
 * consecutively, strictly ascend proceeded by values that consecutively,
 * strictly descend. For example, [0,1,5,4,2] is a mountain array.
 */
fun checkIfMountainArray(arr: IntArray): Boolean {
    var hasDescended = false
    var hasAscended = false
    for (i in 1..<arr.size) {
        if (hasDescended) {
            if (arr[i] > arr[i - 1]) return false
        }

        if (arr[i - 1] < arr[i]) {
            hasAscended = true
        } else {
            if (!hasAscended || arr[i] == arr[i - 1]) return false
            hasDescended = true
        }
    }

    return hasAscended && hasDescended
}

/**
 * Runtime: O(N Log N)
 * Space Complexity: O(N)
 *
 * @param nums the original array
 *
 * @return an [Int] representing the number of elements not in the right
 * position. The array is expected to be monotonically increasing.
 */
fun checkIfSorted(nums: IntArray) : Int {
    val sorted = nums.sorted()
    var wrongCount = 0
    nums.forEachIndexed{ index, num ->
        if (num != sorted[index]) {
            wrongCount++
        }
    }

    return wrongCount
}