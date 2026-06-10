class Solution {
    fun splitArray(nums: IntArray, k: Int): Int {
        fun canSplit(largest: Int): Boolean {
            var subarray = 1
            var curSum = 0
            for (num in nums) {
                curSum += num
                if (curSum > largest) {
                    subarray++
                    if (subarray > k) return false
                    curSum = num
                }
            }
            return true
        }

        var l = nums.max()
        var r = nums.sum()
        var res = r

        while (l <= r) {
            val mid = l + (r - l) / 2
            if (canSplit(mid)) {
                res = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return res
    }
}
