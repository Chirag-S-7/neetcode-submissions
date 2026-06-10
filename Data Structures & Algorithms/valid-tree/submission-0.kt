class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n - 1) return false
        val adj = Array(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            adj[u].add(v)
            adj[v].add(u)
        }
        val visited = BooleanArray(n)
        fun dfs(node: Int) {
            visited[node] = true
            for (nei in adj[node]) {
                if (!visited[nei]) {
                    dfs(nei)
                }
            }
        }
        dfs(0)
        return visited.all { it }
    }
}
