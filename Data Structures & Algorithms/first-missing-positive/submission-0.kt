class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        for (i in 0 until n) {
            if (nums[i] < 0) {
                nums[i] = 0
            }
        }
        for (i in 0 until n) {
            val value = kotlin.math.abs(nums[i])
            if (value in 1..n) {
                if (nums[value - 1] > 0) {
                    nums[value - 1] *= -1
                } else if (nums[value - 1] == 0) {
                    nums[value - 1] = -(n + 1)
                }
            }
        }
        for (i in 0 until n) {
            if (nums[i] >= 0) {
                return i + 1
            }
        }

        return n + 1
    }
}
