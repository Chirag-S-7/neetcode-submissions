class Solution {
    class DSU(n: Int) {
        private val parent = IntArray(n) { it }
        private val size = IntArray(n) { 1 }

        fun find(node: Int): Int {
            if (parent[node] == node) {
                return node
            }

            parent[node] = find(parent[node])
            return parent[node]
        }

        fun union(u: Int, v: Int):Boolean {

            val pu = find(u)
            val pv = find(v)

            if (pu == pv) return false

            if (size[pu] < size[pv]) {
                parent[pu] = pv
                size[pv] += size[pu]
            } else {
                parent[pv] = pu
                size[pu] += size[pv]
            }
            return true
        }
    }
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val dsu = DSU(n)    
        var res = n
        for (edge in edges) {
            val (u, v) = edge
            if (dsu.union(u, v)) {
                res--
            }
        }
        return res
    }
}
