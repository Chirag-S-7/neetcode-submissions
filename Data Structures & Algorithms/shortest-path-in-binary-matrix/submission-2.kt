class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size 
        if(grid[m-1][n-1] ==1 || grid[0][0]==1) return -1
        val dir = arrayOf(
            intArrayOf(1,0),
            intArrayOf(-1,0),
            intArrayOf(0,1),
            intArrayOf(0,-1),
            intArrayOf(1,1),
            intArrayOf(1,-1),
            intArrayOf(-1,1),
            intArrayOf(-1,-1),
        )
        var steps = 1 
        val q = ArrayDeque<Pair<Int,Int>>()
        q.add(0 to 0)
        grid[0][0]=1
        while (q.isNotEmpty()) {
            repeat(q.size) {
                val (r, c) = q.removeFirst()
                if (r == m - 1 && c == n - 1)
                    return steps
                for (d in dir) {
                    val nr = r + d[0]
                    val nc = c + d[1]
                    if (nr !in 0 until m || nc !in 0 until n || grid[nr][nc] == 1)
                        continue
                    grid[nr][nc] = 1
                    q.add(nr to nc)
                }
            }
            steps++
        }
        return -1
    }
}
