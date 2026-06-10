class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0
        fun dfs(r : Int, c : Int){
            if(r<0 || r>=grid.size || c<0 || c>=grid[0].size || grid[r][c]=='0') return 
            grid[r][c]='0'
            dfs(r+1,c)
            dfs(r-1,c)
            dfs(r,c-1)
            dfs(r,c+1)
        }
        for(r in grid.indices){
            for(c in grid[0].indices){
                if(grid[r][c]=='1'){
                    islands++
                    dfs(r,c)
                }
            }
        }
        return islands
    }
}
