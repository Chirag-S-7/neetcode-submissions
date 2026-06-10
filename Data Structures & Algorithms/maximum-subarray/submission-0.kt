class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var currSum = 0
        for(ele in nums){
            currSum+=ele
            result = max(currSum,result)
            if(currSum<0) currSum=0
        }
        return result
    }
}
