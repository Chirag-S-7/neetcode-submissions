class Solution {
    fun findOrder(n: Int, arr: Array<IntArray>): IntArray {
        val result = IntArray(n)
        val indegree = IntArray(n)
        val adj = Array(n){mutableListOf<Int>()}
        val q = ArrayDeque<Int>()
        for(ele in arr){
            indegree[ele[0]]++
            adj[ele[1]].add(ele[0])
        }
        for(i in indegree.indices){
            if(indegree[i]==0){
                q.addLast(i)
            }
        }
        var count = 0
        while(q.isNotEmpty()){
            val f = q.removeFirst()
            result[count] = f
            count++
            for(ele in adj[f]){
                indegree[ele]--
                if(indegree[ele]==0){
                    q.addLast(ele)
                }
            }
        }
        return if (count<n) intArrayOf() else result 
    }
}
