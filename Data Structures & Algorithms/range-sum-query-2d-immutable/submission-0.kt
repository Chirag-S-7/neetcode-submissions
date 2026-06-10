class NumMatrix(matrix: Array<IntArray>) {
    private val prefixSum: Array<IntArray>

    init {
        val rows = matrix.size
        val cols = matrix[0].size
        prefixSum = Array(rows) { IntArray(cols) }

        for (row in 0 until rows) {
            prefixSum[row][0] = matrix[row][0]
            for (col in 1 until cols) {
                prefixSum[row][col] = prefixSum[row][col - 1] + matrix[row][col]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var res = 0
        for (row in row1..row2) {
            res += if (col1 > 0) {
                prefixSum[row][col2] - prefixSum[row][col1 - 1]
            } else {
                prefixSum[row][col2]
            }
        }
        return res
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
