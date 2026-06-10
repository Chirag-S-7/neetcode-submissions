class Solution {
    fun subsetXORSum(nums: IntArray): Int {
        fun dfs(i: Int, total: Int): Int {
            if (i == nums.size) {
                return total
            }
            return dfs(i + 1, total xor nums[i]) + dfs(i + 1, total)
        }

        return dfs(0, 0)
    }
}