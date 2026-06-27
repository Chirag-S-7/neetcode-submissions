private class DSU(
    private val n : Int
) {
    private val parent = Array(n+1){it}
    private val size = Array(n+1){1}
    fun findParent(x:Int):Int{
        if(parent[x]!=x){
            parent[x]=findParent(parent[x])
        }
        return parent[x]
    }
    fun union(x: Int, y: Int): Boolean {
        val rootX = findParent(x)
        val rootY = findParent(y)
        if (rootX == rootY) {
            return false
        }
        if (size[rootX] > size[rootY]) {
            parent[rootY] = rootX
            size[rootX] += size[rootY]
        } else {
            parent[rootX] = rootY
            size[rootY] += size[rootX]
        }
        return true
    }
}
class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
         val dsu = DSU(edges.size)
         for((u,v) in edges){
            if(!(dsu.union(u,v))){
                return intArrayOf(u, v)
            }
         }
         return intArrayOf()
    }
}
