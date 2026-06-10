class ListNode(var key: Int, var next: ListNode? = null)

class MyHashSet() {
    private val set = Array(10000) { ListNode(0) }

    private fun hash(key: Int): Int = key % set.size

    fun add(key: Int) {
        var cur = set[hash(key)]
        while (cur.next != null) {
            if (cur.next!!.key == key) return
            cur = cur.next!!
        }
        cur.next = ListNode(key)
    }

    fun remove(key: Int) {
        var cur = set[hash(key)]
        while (cur.next != null) {
            if (cur.next!!.key == key) {
                cur.next = cur.next!!.next
                return
            }
            cur = cur.next!!
        }
    }

    fun contains(key: Int): Boolean {
        var cur = set[hash(key)]
        while (cur.next != null) {
            if (cur.next!!.key == key) return true
            cur = cur.next!!
        }
        return false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
