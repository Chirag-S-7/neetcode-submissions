class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        val ROWS = grid.size
        val COLS = grid[0].size
        val rowCnt = IntArray(ROWS)
        val colCnt = IntArray(COLS)

        for (r in 0 until ROWS) {
            for (c in 0 until COLS) {
                if (grid[r][c] == 1) {
                    rowCnt[r]++
                    colCnt[c]++
                }
            }
        }

        var res = 0
        for (r in 0 until ROWS) {
            for (c in 0 until COLS) {
                if (grid[r][c] == 1 && maxOf(rowCnt[r], colCnt[c]) > 1) {
                    res++
                }
            }
        }

        return res
    }
}
