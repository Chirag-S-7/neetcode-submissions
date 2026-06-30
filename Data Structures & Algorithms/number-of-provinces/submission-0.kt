class Solution {
    fun findCircleNum(arr: Array<IntArray>): Int {
        val n = arr.size
        val visited = BooleanArray(n)
        fun dfs(i:Int){
            visited[i]=true
            for(j in 0 until n){
                if(arr[i][j]==1 && !visited[j]){
                    dfs(j)
                }
            }
        }
        var count=0
        for(i in 0 until n){
            if(!visited[i]){
                dfs(i)
                count++
            }
        }
        return count
    }
}
