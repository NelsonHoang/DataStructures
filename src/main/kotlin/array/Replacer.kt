package array

/**
 * @param arr the original array
 *
 * @return an [IntArray] where each element is replaced with the largest
 * element to the right of it. Since the last element will not have anything
 * to its right it will be set to -1.
 */
fun replaceElementsWithGreatestElementOnRightSide(arr: IntArray): IntArray {
    var currentGreatest = 0
    for (i in arr.size - 1 downTo 0) {
        val lastElementPos = arr.size - 1
        if (i == lastElementPos) {
            currentGreatest = arr[lastElementPos]
            arr[lastElementPos] = -1
        } else {
            val max = maxOf(currentGreatest, arr[i])
            arr[i] = currentGreatest
            currentGreatest = max
        }
    }
    return arr
}