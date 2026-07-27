class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val dp = Array(n){IntArray(n+1){-1}}
        fun memo(idx:Int,prevIdx:Int):Int{
            if(idx>=n){
                return 0
            }
            if(dp[idx][prevIdx+1]!=-1){
                return dp[idx][prevIdx+1]
            }
            val skip = memo(idx+1,prevIdx)
            val take = if(prevIdx==-1 || nums[idx]>nums[prevIdx]){
                1 + memo(idx+1,idx)
            } else 0
            dp[idx][prevIdx+1] = max(skip,take)
            return dp[idx][prevIdx+1]
        }
        return memo(0,-1)
    }
}
