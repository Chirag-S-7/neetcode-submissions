class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var start = 0
        val n = intervals.size
        while(start<n && intervals[start][1]<newInterval[0]){
            result.add(intervals[start])
            start++
        }
        while(start<n && intervals[start][0]<=newInterval[1]){
            newInterval[0] = min(newInterval[0],intervals[start][0])
            newInterval[1] = max(newInterval[1],intervals[start][1])
            start++
        }
        result.add(newInterval)
        while(start<n){
            result.add(intervals[start])
            start++
        }
        return result.toTypedArray()
    }
}
