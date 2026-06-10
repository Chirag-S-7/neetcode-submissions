class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n){-1}
        fun memo(i:Int): Int{
            if(i>=n){
                return 0
            }
            if(dp[i]!=-1) return dp[i]
            dp[i] = max(nums[i]+memo(i+2),memo(i+1))
            return dp[i]
        }
        return memo(0)
    }
}
