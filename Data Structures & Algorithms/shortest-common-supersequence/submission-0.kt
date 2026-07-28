class Solution {
    fun shortestCommonSupersequence(s1: String, s2: String): String {
        val n = s1.length
        val m = s2.length
        val dp = Array(n + 1) { IntArray(m + 1) }
        for (i in 1..n) {
            for (j in 1..m) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        var i = n
        var j = m
        val ans = StringBuilder()

        while (i > 0 && j > 0) {
            when {
                s1[i - 1] == s2[j - 1] -> {
                    ans.append(s1[i - 1])
                    i--
                    j--
                }
                dp[i - 1][j] >= dp[i][j - 1] -> {
                    ans.append(s1[i - 1])
                    i--
                }
                else -> {
                    ans.append(s2[j - 1])
                    j--
                }
            }
        }
        while (i > 0) {
            ans.append(s1[i - 1])
            i--
        }

        while (j > 0) {
            ans.append(s2[j - 1])
            j--
        }
        return ans.reverse().toString()
    }
}