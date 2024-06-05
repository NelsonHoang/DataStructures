package queue

import org.junit.jupiter.api.Test
import queue.CircularQueue.Companion.EMPTY

class CircularQueueTest {
    private val testCapacity = 5

    @Test
    fun testGeneralUsageWithoutFillingUpQueue() {
        val circularQueue = CircularQueue(testCapacity)
        assert(circularQueue.enqueue(6))
        assert(circularQueue.enqueue(4))
        assert(circularQueue.dequeue())

        assert(circularQueue.enqueue(5))
        assert(circularQueue.dequeue())
        assert(circularQueue.enqueue(3))
        assert(circularQueue.dequeue())
        assert(circularQueue.enqueue(1))
        assert(circularQueue.dequeue())
        assert(circularQueue.front() == 1)
    }

    @Test
    fun testGeneralUsageWithFillingUpQueue() {
        val circularQueue = CircularQueue(2)
        assert(circularQueue.enqueue(6))
        assert(circularQueue.enqueue(4))
        assert(circularQueue.dequeue())

        assert(circularQueue.enqueue(5))
        assert(circularQueue.dequeue())
        assert(circularQueue.enqueue(3))
        assert(circularQueue.dequeue())
        assert(circularQueue.enqueue(1))
        assert(circularQueue.dequeue())
        assert(circularQueue.front() == 1)
    }

    @Test
    fun frontWithEmptyQueue() {
        val circularQueue = CircularQueue(testCapacity)
        assert(circularQueue.front() == EMPTY)

        circularQueue.enqueue(1)
        circularQueue.enqueue(2)
        circularQueue.dequeue()
        circularQueue.dequeue()
        assert(circularQueue.front() == EMPTY)
    }

    @Test
    fun frontWithNonEmptyQueue() {
        val circularQueue = CircularQueue(testCapacity)
        val firstValue = 1
        circularQueue.enqueue(firstValue)
        circularQueue.enqueue(2)
        assert(circularQueue.front() == firstValue)
    }

    @Test
    fun rearWithEmptyQueue() {
        val circularQueue = CircularQueue(testCapacity)
        assert(circularQueue.rear() == EMPTY)

        circularQueue.enqueue(1)
        circularQueue.enqueue(2)
        circularQueue.dequeue()
        circularQueue.dequeue()
        assert(circularQueue.rear() == EMPTY)
    }

    @Test
    fun rearWithNonEmptyQueue() {
        val circularQueue = CircularQueue(testCapacity)
        val thirdValue = 3
        circularQueue.enqueue(1)
        circularQueue.enqueue(2)
        circularQueue.enqueue(thirdValue)
        assert(circularQueue.rear() == thirdValue)
    }

    @Test
    fun enqueueQueueNotAtCapacity() {
        val circularQueue = CircularQueue(testCapacity)
        for (i in 0..<testCapacity) {
            assert(circularQueue.enqueue(i))
        }
    }

    @Test
    fun enqueueQueueAtCapacity() {
        val circularQueue = CircularQueue(testCapacity)
        for (i in 0..<testCapacity) {
            circularQueue.enqueue(i)
        }
        assert(!circularQueue.enqueue(1))
    }

    @Test
    fun dequeueQueueIsEmpty() {
        val circularQueue = CircularQueue(testCapacity)
        assert(!circularQueue.dequeue())

        circularQueue.enqueue(1)
        circularQueue.enqueue(2)
        circularQueue.dequeue()
        circularQueue.dequeue()
        assert(!circularQueue.dequeue())
    }

    @Test
    fun dequeueQueueIsNotEmpty() {
        val circularQueue = CircularQueue(testCapacity)
        circularQueue.enqueue(1)
        assert(circularQueue.dequeue())
    }

    @Test
    fun isFullQueueWithCapacity() {
        val circularQueue = CircularQueue(testCapacity)
        circularQueue.enqueue(1)
        assert(!circularQueue.isFull())
    }

    @Test
    fun isFullQueueWithoutCapacity() {
        val circularQueue = CircularQueue(testCapacity)
        for (i in 0..<testCapacity) {
            circularQueue.enqueue(i)
        }
        assert(circularQueue.isFull())
    }

    @Test
    fun isEmptyQueueWithNothing() {
        val circularQueue = CircularQueue(testCapacity)
        assert(circularQueue.isEmpty())

        circularQueue.enqueue(1)
        circularQueue.enqueue(2)
        circularQueue.dequeue()
        circularQueue.dequeue()
        assert(circularQueue.isEmpty())
    }

    @Test
    fun isEmptyQueueWithSomething() {
        val circularQueue = CircularQueue(testCapacity)
        circularQueue.enqueue(1)
        assert(!circularQueue.isEmpty())
    }
}