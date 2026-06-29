class Solution {
    fun minimumTotal(arr: List<List<Int>>): Int {
        val n = arr.size
        val dp = Array(n) { IntArray(n) { Int.MAX_VALUE } }
        fun dfs(i:Int,j:Int):Int{
            if (j < 0 || j > i) return 1_000_000_000
            if (i == 0 && j == 0) return arr[0][0]
            if (dp[i][j] != Int.MAX_VALUE)
                return dp[i][j]
            val up = arr[i][j] + dfs(i - 1, j)
            val diag = arr[i][j] + dfs(i - 1, j - 1)
            dp[i][j] = minOf(up, diag)
            return dp[i][j]
        }
        var mn = Int.MAX_VALUE
        for(i in 0 until n){
            mn=min(mn, dfs(n-1,i))
        }
        return mn
    }  
}
