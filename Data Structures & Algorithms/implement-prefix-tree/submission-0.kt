class TrieNode {
    val children = arrayOfNulls<TrieNode>(26)
    var endOfWord = false
}

class PrefixTree {
    private val root = TrieNode()

    fun insert(word: String) {
        var cur = root
        for (c in word) {
            val i = c - 'a'
            if (cur.children[i] == null) {
                cur.children[i] = TrieNode()
            }
            cur = cur.children[i]!!
        }
        cur.endOfWord = true
    }

    fun search(word: String): Boolean {
        var cur = root
        for (c in word) {
            val i = c - 'a'
            if (cur.children[i] == null) {
                return false
            }
            cur = cur.children[i]!!
        }
        return cur.endOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        for (c in prefix) {
            val i = c - 'a'
            if (cur.children[i] == null) {
                return false
            }
            cur = cur.children[i]!!
        }
        return true
    }
}
