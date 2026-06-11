class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val n = nums.size
        val dp = Array(n) { IntArray(2001) { Int.MIN_VALUE } }
        fun memo(i:Int,target:Int):Int{
            if (i == n) {
                return if (target == 0) 1 else 0
            }
            if (target < -1000 || target > 1000) {
                return 0
            }
            if(dp[i][target+1000]!=Int.MIN_VALUE) return dp[i][target+1000]
            val takePos = memo(i+1,target-nums[i])
            val takeNeg = memo(i+1,target+nums[i])
            dp[i][target+1000] = takePos+takeNeg
            return takePos+takeNeg
        }
        return memo(0,target)
    }
}
