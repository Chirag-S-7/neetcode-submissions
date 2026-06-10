class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var globMax = nums[0]
        var globMin = nums[0]
        var curMax = 0
        var curMin = 0
        var total = 0

        for (num in nums) {
            curMax = maxOf(curMax + num, num)
            curMin = minOf(curMin + num, num)
            total += num
            globMax = maxOf(globMax, curMax)
            globMin = minOf(globMin, curMin)
        }

        return if (globMax > 0) maxOf(globMax, total - globMin) else globMax
    }
}
