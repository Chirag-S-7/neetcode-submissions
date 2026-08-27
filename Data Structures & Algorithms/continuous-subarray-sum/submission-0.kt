class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val remainder = mutableMapOf(0 to -1)
        var total = 0

        for (i in nums.indices) {
            total += nums[i]
            val r = total % k
            if (r !in remainder) {
                remainder[r] = i
            } else if (i - remainder[r]!! > 1) {
                return true
            }
        }

        return false
    }
}
