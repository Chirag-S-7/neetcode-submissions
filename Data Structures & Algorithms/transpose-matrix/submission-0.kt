class Solution {
    fun transpose(arr: Array<IntArray>): Array<IntArray> {
        val m = arr.size
        val n = arr[0].size
        val result = Array(n){IntArray(m)}
        for(i in 0 until m){
            for(j in 0 until n){
                result[j][i]=arr[i][j]
            }
        }
        return result
    }
}
