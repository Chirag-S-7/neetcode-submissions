class Solution {
    fun checkIfPrerequisite(numCourses: Int, arr: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val indegree = IntArray(numCourses)
        val adj = Array(numCourses){mutableListOf<Int>()}
        val isPrereq = Array(numCourses) { mutableSetOf<Int>() }
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
            for(ele in adj[f]){
                isPrereq[ele].add(f)
                isPrereq[ele].addAll(isPrereq[f])
                indegree[ele]--
                if(indegree[ele]==0){
                    q.addLast(ele)
                }
            }
        }
            return queries.map { isPrereq[it[0]].contains(it[1]) 
        }
    }
}
