class Solution {
    fun numDecodings(s: String): Int {
        val n = s.length
        val dp = IntArray(n) { -1 }

        fun dfs(i: Int): Int {
            if (i == n) return 1
            if (s[i] == '0') return 0

            if (dp[i] != -1) return dp[i]

            var ans = dfs(i + 1)

            if (
                i + 1 < n &&
                (s[i] == '1' ||
                 (s[i] == '2' && s[i + 1] <= '6'))
            ) {
                ans += dfs(i + 2)
            }

            dp[i] = ans
            return ans
        }

        return dfs(0)
    }
}
