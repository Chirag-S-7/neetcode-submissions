class NumArray(nums: IntArray) {
    val n=nums.size
    val prefixSum = IntArray(n+1)
    init{
        for(i in 0 until n){
            prefixSum[i+1]=prefixSum[i]+nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return prefixSum[right+1]-prefixSum[left]
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */