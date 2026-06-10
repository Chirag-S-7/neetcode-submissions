class Solution {
    fun canFinish(n: Int, arr: Array<IntArray>): Boolean {
        val adjList = MutableList(n) { mutableListOf<Int>() }
        val indegree = IntArray(n){ 0 }
        for(l in arr){
            adjList[l[1]].add(l[0])
            indegree[l[0]]++
        }
        val q = LinkedList<Int>()
        for(i in indegree.indices){
            if(indegree[i]==0){
                q.addLast(i)
            }
        }
        var course = 0 
        while(q.isNotEmpty()){
            val c = q.removeFirst()
            course++
            for(i in adjList[c]){
                indegree[i]--
                if(indegree[i]==0){
                    q.addLast(i)
                }
            }
        }
        return course==n
    }
}
