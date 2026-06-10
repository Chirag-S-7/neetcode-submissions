class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) {
            return false
        }
        val target = sum / 2
        val n = nums.size
        val memo = Array(n + 1) { IntArray(target + 1) { -1 } }
        fun dp(i:Int,target:Int):Boolean{
            if(target==0) return true
            if(i>=n || target<0){
                return false
            }
            if(memo[i][target]!=-1) return memo[i][target]==1
            val take = dp(i+1,target-nums[i])
            val notTake = dp(i+1,target)
            val found = take || notTake
            memo[i][target] = if(found) 1 else 0
            return found
        }
        return dp(0,target)
    }
}
