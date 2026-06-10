class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val row = matrix.size
        val col = matrix[0].size
        val total = row*col
        var start = 0
        var end = total-1
        while(start<=end){
            val mid = end-start/2 + start
            val curr = matrix[mid/col][mid%col]
            when {
                curr==target-> return true
                curr<target-> start = mid+1
                else->end = mid-1
            }
        }
        return false

    }
}
