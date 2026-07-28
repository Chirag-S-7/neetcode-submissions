class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length
        val dp = Array(n) { IntArray(n) { -1 } }

        fun isPalindrome(i: Int, j: Int): Boolean {
            if (i >= j) return true

            if (dp[i][j] != -1) {
                return dp[i][j] == 1
            }

            if (s[i] != s[j]) {
                dp[i][j] = 0
                return false
            }

            val ans = isPalindrome(i + 1, j - 1)
            dp[i][j] = if (ans) 1 else 0
            return ans
        }

        var count = 0
        for (i in 0 until n) {
            for (j in i until n) {
                if (isPalindrome(i, j)) {
                    count++
                }
            }
        }

        return count
    }
}