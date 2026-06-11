class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { -1 } }
        fun memo(i:Int,j:Int):Int{
            if(i==m-1 && j==n-1){
                return 1
            }
            if(i>=m || j>=n){
                return 0
            }
            if(dp[i][j]!=-1) return dp[i][j]
            dp[i][j]=memo(i,j+1)+memo(i+1,j)
            return dp[i][j]
        }
        return memo(0,0)
    }
}
