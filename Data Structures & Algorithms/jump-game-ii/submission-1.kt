class Solution {
    fun jump(nums: IntArray): Int {
        val n = nums.size
        val memo = IntArray(n) { -1 }

        fun mnJumps(idx: Int): Int {
            if (idx == n - 1) return 0

            if (memo[idx] != -1)
                return memo[idx]

            var mn = Int.MAX_VALUE

            for (i in 1..nums[idx]) {
                if (idx + i < n) {
                    val jumps = mnJumps(idx + i)

                    if (jumps != Int.MAX_VALUE) {
                        mn = minOf(mn, 1 + jumps)
                    }
                }
            }

            memo[idx] = mn
            return mn
        }

        return mnJumps(0)
    }
}
