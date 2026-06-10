class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val indegree = IntArray(n)
        val outdegree = IntArray(n)
        for(t in trust){
            indegree[t[0]-1]++
            outdegree[t[1]-1]++
        }
        for(i in indegree.indices){
            if(indegree[i]==0 && outdegree[i]==n-1){
                return i+1
            }
        }
        return -1
    }
}