class Solution {
    fun networkDelayTime(arr: Array<IntArray>, n: Int, k: Int): Int {
        val adj = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        val dist = IntArray(n+1){Int.MAX_VALUE}
        val pq = PriorityQueue<Pair<Int,Int>>(compareBy { it.first })
        for ((u, v, w) in arr) {
            adj[u].add(v to w)
        }
        dist[k]=0
        pq.add(Pair(0,k))
        while(pq.isNotEmpty()){
            val (d,node) = pq.poll()
            for((nxt,wt) in adj[node]){
                if(wt+d<dist[nxt]){
                    dist[nxt]=wt+d
                    pq.add(Pair(wt+d,nxt))
                }
            }
        }
        var ans = -1
        for(i in 1 until n+1){
            if(dist[i]==Int.MAX_VALUE) return -1
            ans=max(ans,dist[i])
        }
        return ans
    }
}
