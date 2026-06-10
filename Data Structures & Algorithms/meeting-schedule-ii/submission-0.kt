/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        var mt = mutableListOf<Pair<Int,Int>>()
        for(i in intervals){
            mt.add(i.start to 1)
            mt.add(i.end to -1)
        }
        mt.sortWith(
            compareBy<Pair<Int, Int>> { it.first }
                .thenBy { it.second }
        )
        var count = 0
        var result = 0
        for(i in mt){
            count+=i.second
            result = max(result,count)
        }
        return result
    }
}
