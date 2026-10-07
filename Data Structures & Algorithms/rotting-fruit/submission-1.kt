class Solution {
    private val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0)
        )

    fun orangesRotting(grid: Array<IntArray>): Int {
        var totalMinutes = 0
        var freshOranges = 0
        val row = grid.size
        val col = grid[0].size
        val q = ArrayDeque<Pair<Int,Int>>()
        for(i in 0 until row){
            for(j in 0 until col){
                if(grid[i][j]==2){
                    q.addLast(Pair(i,j))
                }
                else if(grid[i][j]==1){
                    freshOranges++
                }
            }
        }
        while(freshOranges> 0 && q.isNotEmpty()){
            val length = q.size
            repeat(length){
            val (x,y) = q.removeFirst()
            for(d in directions){
                val dx = d[0]+x
                val dy = d[1]+y
                if(dx in 0 until row && dy in 0 until col && grid[dx][dy]==1){
                    grid[dx][dy]=2
                    q.addLast(Pair(dx,dy))
                    freshOranges--
                }
            }
            }
            totalMinutes++
        }
        return if(freshOranges> 0) -1 else  totalMinutes 
    }
}
