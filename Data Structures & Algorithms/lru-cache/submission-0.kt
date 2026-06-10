class LRUCache(private val capacity: Int) {

    class Node(
        val key: Int,
        var value: Int,
        var next: Node? = null,
        var prev: Node? = null
    )

    private val mp = mutableMapOf<Int, Node>()

    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if (!mp.containsKey(key)) {
            return -1
        }

        val node = mp[key]!!

        removeNode(node)
        addToFront(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        if (mp.containsKey(key)) {
            val existingNode = mp[key]!!
            existingNode.value = value
            removeNode(existingNode)
            addToFront(existingNode)
            return
        }
        val newNode = Node(key, value)
        mp[key] = newNode
        addToFront(newNode)
        if (mp.size > capacity) {
            val lruNode = tail.prev!!
            removeNode(lruNode)
            mp.remove(lruNode.key)
        }
    }

    private fun addToFront(node: Node) {

        val firstNode = head.next

        head.next = node
        node.prev = head

        node.next = firstNode
        firstNode?.prev = node
    }

    private fun removeNode(node: Node) {

        val prevNode = node.prev
        val nextNode = node.next

        prevNode?.next = nextNode
        nextNode?.prev = prevNode
    }
}
