package heap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HeapTest {
    @Test
    fun minHeap() {
        val minHeap = Heap.minHeap()
        minHeap += 1
        minHeap += 2
        minHeap += 3
        minHeap += 4
        assertEquals(1, minHeap.peek())

        assertEquals(1,  minHeap.pop())
        assertEquals(2,  minHeap.peek())
    }

    @Test
    fun maxHeap() {
        val maxHeap = Heap.maxHeap()
        maxHeap += 1
        maxHeap += 2
        maxHeap += 3
        maxHeap += 4
        assertEquals(4, maxHeap.peek())

        assertEquals(4,  maxHeap.pop())
        assertEquals(3,  maxHeap.peek())
    }
}