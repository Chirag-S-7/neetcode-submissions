class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>): Unit {
        val m = grid.size
        val n = grid[0].size
        val q: Queue<Pair<Int, Int>> = LinkedList()

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) {
                    q.add(Pair(i, j))
                }
            }
        }
        if (q.isEmpty()) return

        val dirs = arrayOf(
            intArrayOf(-1, 0), intArrayOf(0, -1),
            intArrayOf(1, 0), intArrayOf(0, 1)
        )

        while (q.isNotEmpty()) {
            val (row, col) = q.poll()
            for (dir in dirs) {
                val r = row + dir[0]
                val c = col + dir[1]
                if (r !in 0 until m || c !in 0 until n ||
                    grid[r][c] != Int.MAX_VALUE) {
                    continue
                }
                q.add(Pair(r, c))
                grid[r][c] = grid[row][col] + 1
            }
        }
    }
}
