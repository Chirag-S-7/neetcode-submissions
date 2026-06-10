class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(compareByDescending{ it })
        for(st in stones){
            maxHeap.offer(st)
        }
        while(maxHeap.isNotEmpty()){
            val x = maxHeap.poll()
            var y = 0
            if(maxHeap.isNotEmpty()){
                y = maxHeap.poll()
            } else {
                return x
            }
            val target = x-y
            if(target>0){
                maxHeap.offer(target)
            }
        }
        return 0
    }
}
