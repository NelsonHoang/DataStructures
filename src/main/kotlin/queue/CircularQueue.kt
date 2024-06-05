package queue

class CircularQueue(capacity: Int) {
    private val array = IntArray(capacity)

    private var headPointer: Int? = null
    private var tailPointer: Int? = null
    private var size: Int = 0

    /**
     * @return the head of the Queue or [EMPTY] is the queue is empty.
     */
    fun front(): Int {
        return if (headPointer == null) {
            EMPTY
        } else {
            array[headPointer!!]
        }
    }

    /**
     * @return the tail of the Queue or [EMPTY] is the queue is empty.
     */
    fun rear(): Int {
        return if (tailPointer == null) {
            EMPTY
        } else {
            array[tailPointer!!]
        }
    }

    /**
     * @return true if we successfully enqueued the value and false if we failed
     * because the Queue is full.
     */
    fun enqueue(value: Int): Boolean {
        if (isFull()) {
            return false // Queue at capacity
        }

        size++
        if (headPointer == null) {
            headPointer = 0
        }
        tailPointer = getNextPointer(tailPointer)
        array[tailPointer!!] = value
        return true
    }

    /**
     * @return true if we successfully dequeued the head of the queue and false
     * if otherwise
     */
    fun dequeue(): Boolean {
        if (isEmpty()) {
            return false
        }

        size--
        if (size == 0) {
            headPointer = null
            tailPointer = null
        } else {
            headPointer = getNextPointer(headPointer)
        }

        return true
    }

    /**
     * @return true if the queue is full and false otherwise
     */
    fun isFull(): Boolean {
        return getNextPointer(tailPointer) == headPointer
    }

    /**
     * @return true if the queue is empty and false otherwise
     */
    fun isEmpty(): Boolean {
        return headPointer == null && tailPointer == null
    }

    /**
     * @return The index after incrementing a pointer. If we are at the end of
     * the backing array we need to wrap the value and return 0.
     */
    private fun getNextPointer(currentPointer: Int?): Int {
        return if (currentPointer == array.size - 1 || currentPointer == null) {
            0
        } else {
            currentPointer + 1
        }
    }

    companion object {
        const val EMPTY = -1
    }
}