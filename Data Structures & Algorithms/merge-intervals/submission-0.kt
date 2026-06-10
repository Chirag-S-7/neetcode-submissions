class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val sortedInterval = intervals.sortedBy { it[0] }
        val result = mutableListOf<IntArray>()
        result.add(sortedInterval[0])
        for(i in 1 until sortedInterval.size){
            val last = result.last()[1]
            if(last>=sortedInterval[i][0]){
                result.last()[1] = max(last,sortedInterval[i][1])
            } else {
                result.add(sortedInterval[i])
            }
        }
        return result.toTypedArray()
    }
}
