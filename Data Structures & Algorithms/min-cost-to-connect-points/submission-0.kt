class DSU {

}
class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size
        val size = IntArray(n+1){1}
        val parent = IntArray(n+1){it}
        fun findParent(x:Int):Int{
            if (parent[x] != x) {
                parent[x] = findParent(parent[x]) 
            }
            return parent[x]
        }
        fun union(u:Int,v:Int):Boolean{
            var pu = findParent(u)
            var pv = findParent(v)
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
        val edges = mutableListOf<Triple<Int, Int, Int>>()

        for (i in 0 until n) {
            val (x1, y1) = points[i]
            for (j in i + 1 until n) {
                val (x2, y2) = points[j]
                val dist = abs(x1 - x2) + abs(y1 - y2)
                edges.add(Triple(dist, i, j))
            }
        }
        edges.sortBy { it.first }
        var res = 0
        for ((dist, u, v) in edges) {
            if (union(u, v)) {
                res += dist
            }
        }
        return res
    }
}
