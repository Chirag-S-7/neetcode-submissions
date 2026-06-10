class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        fun findDistance(x:Int,y:Int):Int {
            return (x*x)+(y*y)
        }
        val pq = PriorityQueue<Pair<Int,IntArray>>(compareByDescending{it.first})
        val result = Array(k){IntArray(2)}
        for(p in points){
            val d = findDistance(p[0],p[1])
            pq.add(d to p)
            if(pq.size>k){
                pq.poll()
            }
        }
        var idx = 0
        while(pq.isNotEmpty()){
            result[idx]=pq.poll().second
            idx++
        }
        return result
    }
}
