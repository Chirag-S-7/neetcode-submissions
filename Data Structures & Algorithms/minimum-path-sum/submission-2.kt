class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m){IntArray(n)}
        for(i in 0 until m){
            for(j in 0 until n){
                if(i==0 && j==0) dp[i][j] = grid[0][0] 
                else {
                    var up = 1_000_000_000
                    var left = 1_000_000_000
                    if(i>0) left = grid[i][j]+dp[i-1][j]
                    if(j>0) up = grid[i][j]+dp[i][j-1]
                    dp[i][j]=min(left,up)
                }
            }
        }
        return dp[m-1][n-1]
    }
}
