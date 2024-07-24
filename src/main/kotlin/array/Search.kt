package array

/**
 * @param [arr] the original [IntArray]
 *
 * @return true if a value and its double exists. For example, the function
 * will return true if 5 and 10 are in the array.
 */
fun checkIfNAndDoubleExists(arr: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (num in arr) {
        if (set.contains(num * 2)) {
            return true
        }
        if (num % 2 == 0 && set.contains(num / 2)) {
            return true
        }
        set.add(num)
    }

    return false
}