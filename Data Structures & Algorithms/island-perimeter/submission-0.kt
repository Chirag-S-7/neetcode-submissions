class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var res = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    if (i + 1 >= m || grid[i + 1][j] == 0) res++
                    if (j + 1 >= n || grid[i][j + 1] == 0) res++
                    if (i - 1 < 0 || grid[i - 1][j] == 0) res++
                    if (j - 1 < 0 || grid[i][j - 1] == 0) res++
                }
            }
        }
        return res
    }
}
