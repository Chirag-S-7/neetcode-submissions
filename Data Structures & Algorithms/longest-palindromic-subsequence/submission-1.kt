class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        val n = s.length
        val dp = Array(n){IntArray(n)}
        for(i in 0 until n){
            dp[i][i]=1
        }
        for(L in 2..n){
            for(i in 0 until n-L+1){
                val j = L+i-1
                if(s[i]==s[j]){
                    dp[i][j]=2+dp[i+1][j-1]
                }else {
                    dp[i][j]=max(dp[i+1][j],dp[i][j-1])
                }
            }
        }
        return dp[0][n-1]
    }
}