class MyCircularQueue(k: Int) {
    private val q = IntArray(k)
    private val capacity = k
    private var front = 0
    private var rear = -1
    private var size = 0

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false
        rear = (rear + 1) % capacity
        q[rear] = value
        size++
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        front = (front + 1) % capacity
        size--
        return true
    }

    fun Front(): Int {
        return if (isEmpty()) -1 else q[front]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1 else q[rear]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == capacity
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
