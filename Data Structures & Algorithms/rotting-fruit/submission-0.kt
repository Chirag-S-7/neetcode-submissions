class Solution {
    private val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0)
        )

    fun orangesRotting(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var fresh = 0
        var queue = ArrayDeque<Pair<Int,Int>>()
        var minutes = 0
        for(r in 0 until rows){
            for(c in 0 until cols){
                if(grid[r][c]==1){
                    fresh++
                }
                if(grid[r][c]==2){
                    queue.addLast(r to c)
                }
            }
        }

        while(fresh>0 && queue.isNotEmpty()){
            val length = queue.size
            repeat(length){
                val curr = queue.removeFirst()
                for(d in directions){
                    val dx = curr.first+d[0]
                    val dy = curr.second+d[1]
                    if(dx in 0 until rows && 
                        dy in 0 until cols &&
                        grid[dx][dy]==1
                    ){
                        grid[dx][dy]=2
                        queue.addLast(dx to dy)
                        fresh--
                    }
                }
            }
            minutes++
        }
        return if (fresh > 0) -1 else minutes
    }
}
