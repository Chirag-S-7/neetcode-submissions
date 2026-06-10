class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        intervals.sortBy { it[1] }
        var removeCount = 0
        var prevEnd = intervals[0][1]

        for (i in 1 until intervals.size) {

            val start = intervals[i][0]
            val end = intervals[i][1]

            if (start < prevEnd) {
                removeCount++
            } else {
                prevEnd = end
            }
        }

        return removeCount
    }
}
