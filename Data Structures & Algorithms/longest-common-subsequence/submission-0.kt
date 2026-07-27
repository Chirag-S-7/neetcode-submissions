class Solution {
    fun longestCommonSubsequence(s1: String, s2: String): Int {
        val m = s1.length
        val n = s2.length
        val dp = Array(m+1){IntArray(n+1){-1}}
        fun memo(i:Int,j:Int):Int{
            if(i>=m || j>=n){
                return 0
            }
            if(dp[i][j]!=-1){
                return dp[i][j]
            }
            if(s1[i]==s2[j]){
                dp[i][j]=1+memo(i+1,j+1)
            }else{
                val moveI = memo(i+1,j)
                val moveJ = memo(i,j+1)
                dp[i][j]=max(moveI,moveJ)
            }
            return dp[i][j]
        }
        return memo(0,0)
    }
}
