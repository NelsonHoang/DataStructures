package array

fun binarySearch(nums: IntArray, target: Int): Int {
    fun recurse(nums: IntArray, target: Int, low: Int, high: Int): Int {
        if (low > high) return -1

        val mid = (low + high) / 2
        val currentValue = nums[mid]
        if (currentValue < target) {
            return recurse(nums, target, mid + 1, high)
        } else if (currentValue > target) {
            return recurse(nums, target, low, mid -1)
        }

        return mid
    }

    return recurse(nums, target, 0, nums.size - 1)
}