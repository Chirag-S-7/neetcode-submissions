class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>()
        for(n in nums){
            pq.add(n)
            if(pq.size>k){
                pq.poll()
            }
        }
        return pq.peek()
    }
}
