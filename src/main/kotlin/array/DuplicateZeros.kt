package array

/**
 * @param arr the original [IntArray]
 *
 * @return An [IntArray] that duplicates 0s and shifts elements to the right.
 * For example, [0,1,2,0,4,5] becomes [0,0,1,2,0,0]
 */
fun duplicateZeros(arr: IntArray) : IntArray {
    var index = 0
    while (index < arr.size) {
        if (arr[index] == 0 && index != arr.size - 1) {
            var next : Int = arr[index + 1]
            arr[index + 1] = 0
            index += 2
            for (i in index..<arr.size) {
                val toReplace = arr[i]
                arr[i] = next
                next = toReplace
            }
        } else {
            index++
        }
    }
    return arr
}