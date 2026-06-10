class Solution {
    fun minSubArrayLen(t: Int, nums: IntArray): Int {
        var result = Int.MAX_VALUE
        var sum = 0
        var start = 0
        for(end in nums.indices){
            sum+=nums[end]
            while(sum>=t){
                sum-=nums[start]
                result=min(result,end-start+1)
                start++
            }
        }
        return if(result==Int.MAX_VALUE) 0 else result
    }
}
