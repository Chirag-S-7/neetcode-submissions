/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        var totalRooms = 0
        var count = 0
        val timing = mutableListOf<Pair<Int,Int>>()
        for(interval in intervals){
            timing.add(interval.start to 1)
            timing.add(interval.end to -1)
        }
        timing.sortWith(
            compareBy<Pair<Int, Int>> { it.first }
            .thenBy { it.second }
        )
        for(t in timing){
            count+=t.second
            totalRooms=max(count,totalRooms)
        }
        return totalRooms
    }
}
