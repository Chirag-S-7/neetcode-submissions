class Solution {
    private val dir = arrayOf(
            intArrayOf(1,0),
            intArrayOf(-1,0),
            intArrayOf(0,1),
            intArrayOf(0,-1),
        )
    fun minimumEffortPath(arr: Array<IntArray>): Int {
        val m = arr.size
        val n = arr[0].size 
        val distance = Array(m){IntArray(n){Int.MAX_VALUE}}
        val pq = PriorityQueue<Pair<Int, Pair<Int, Int>>>(compareBy { it.first })
        pq.add(0 to (0 to 0))
        distance[0][0]=0
        while(pq.isNotEmpty()){
            val (dis,node) = pq.poll()
            val r = node.first
            val c = node.second
            for(d in dir){
                val nr =  r + d[0]
                val nc =  c + d[1]
                if (nr !in 0 until m || nc !in 0 until n)
                        continue
                val wt = abs(arr[nr][nc]-arr[r][c])
                val newEffort = maxOf(dis, wt)
                if (newEffort < distance[nr][nc]) {
                    distance[nr][nc] = newEffort
                    pq.add(newEffort to (nr to nc))
                }
            }
        }
        return distance[m-1][n-1]
    }
}
