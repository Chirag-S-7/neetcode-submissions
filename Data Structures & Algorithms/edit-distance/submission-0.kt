class Solution {
    fun minDistance(w1: String, w2: String): Int {
        val n = w1.length
        val m = w2.length

        val dp = Array(n + 1) { IntArray(m + 1) { -1 } }

        fun memo(i: Int, j: Int): Int {
            if (i == n) return m - j
            if (j == m) return n - i

            if (dp[i][j] != -1) return dp[i][j]

            if (w1[i] == w2[j]) {
                dp[i][j] = memo(i + 1, j + 1)
                return dp[i][j]
            }

            val delete = memo(i + 1, j)
            val replace = memo(i + 1, j + 1)
            val insert = memo(i, j + 1)

            dp[i][j] = 1 + minOf(delete, replace, insert)
            return dp[i][j]
        }

        return memo(0, 0)
    }
}