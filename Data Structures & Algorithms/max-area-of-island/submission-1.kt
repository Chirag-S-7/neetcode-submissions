class Solution {

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0

        fun dfs(r: Int, c: Int): Int {
            if (
                r < 0 || r >= grid.size ||
                c < 0 || c >= grid[0].size ||
                grid[r][c] == 0
            ) return 0

            grid[r][c] = 0

            return 1 +
                    dfs(r + 1, c) +
                    dfs(r - 1, c) +
                    dfs(r, c + 1) +
                    dfs(r, c - 1)
        }

        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] == 1) {
                    maxArea = maxOf(maxArea, dfs(r, c))
                }
            }
        }

        return maxArea
    }
}
