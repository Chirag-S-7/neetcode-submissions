class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val result = IntArray(n-k+1)
        var start = 1
        val mxHeap = PriorityQueue<Pair<Int,Int>>(compareByDescending{ it.first })
        for(end in 0 until k){
            mxHeap.add(nums[end] to end)
        }
        result[0] = mxHeap.peek().first
        var idx = 1
        for(end in k until nums.size){
            mxHeap.add(nums[end] to end)
            while(mxHeap.peek().second<start){
                mxHeap.poll()
            }
            result[idx++] = mxHeap.peek().first
            start++
        }
        return result
    }
}
