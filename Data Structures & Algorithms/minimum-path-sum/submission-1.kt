class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m){IntArray(n){-1}}
        fun dfs(i:Int,j:Int):Int{
            if(i==0 && j==0) return grid[0][0]
            if(i<0 || j<0) return 1_000_000_000
            if(dp[i][j]!=-1) return dp[i][j]
            val left = grid[i][j]+dfs(i-1,j)
            val up = grid[i][j]+dfs(i,j-1)
            dp[i][j]=min(left,up)
            return dp[i][j]
        }
        return dfs(m-1,n-1)
    }
}
