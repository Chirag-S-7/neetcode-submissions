class Solution {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        if (p == 0) return 0

        nums.sort()
        val n = nums.size

        fun isValid(threshold: Int): Boolean {
            var i = 0
            var cnt = 0
            while (i < n - 1) {
                if (kotlin.math.abs(nums[i] - nums[i + 1]) <= threshold) {
                    cnt++
                    i += 2
                } else {
                    i++
                }
                if (cnt == p) return true
            }
            return false
        }

        var l = 0
        var r = nums[n - 1] - nums[0]
        var res = r

        while (l <= r) {
            val m = l + (r - l) / 2
            if (isValid(m)) {
                res = m
                r = m - 1
            } else {
                l = m + 1
            }
        }

        return res
    }
}