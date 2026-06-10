class KthLargest(k: Int, nums: IntArray) {
    private val mn = PriorityQueue<Int>()
    private val n = k
    init {
        for(num in nums){
            mn.add(num)
        }
        while(mn.size>n){
            mn.poll()
        }
    }
    fun add(`val`: Int): Int {
        mn.add(`val`)
        if(mn.size > n){
            mn.poll()
        }
        return mn.peek()
    }
}
