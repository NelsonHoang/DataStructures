package array

/**
 * @param nums1 a sorted [IntArray] with trailing 0s the same size as nums2
 * @param nums2 a sorted [IntArray]
 *
 * @return the sorted [IntArray] after merging [nums1] and [nums2]
 */
fun mergeSortedArrays(nums1: IntArray, nums2: IntArray): IntArray {
    var index = nums1.size - 1
    var ptr1 = nums1.size - nums2.size - 1
    var ptr2 = nums2.size - 1

    while (ptr2 > -1) {
        if (ptr1 < 0 || nums1[ptr1] < nums2[ptr2]) {
            nums1[index] = nums2[ptr2]
            ptr2--
        } else {
            nums1[index] = nums1[ptr1]
            ptr1--
        }
        index--
    }

    return nums1
}