class Solution {
    fun spiralOrder(arr: Array<IntArray>): List<Int> {
        val n = arr.size
        val m = arr[0].size
        val result = mutableListOf<Int>()
        var left = 0
        var right = m-1
        var top = 0
        var bottom = n-1
        while(left<=right && top<=bottom){
            for(i in left..right){
                result.add(arr[top][i])
            }
            top++
            for(i in top..bottom){
                result.add(arr[i][right])
            }
            right--
            if(top<=bottom){
                for(i in right downTo left){
                    result.add(arr[bottom][i])
                }
                bottom--
            }
            
            if(left<=right){
                for(i in bottom downTo top){
                    result.add(arr[i][left])
                }
                left++
            }
        }
        return result
    }
}
