class Solution {
    fun averageWaitingTime(arr: Array<IntArray>): Double {
        var totalTime = 0L
        var finish = arr[0][0].toLong()

        for ((a, t) in arr) {
            if (finish < a) {
                totalTime += t
                finish = a.toLong() + t
            } else {
                totalTime += finish - a + t
                finish += t
            }
        }

        return totalTime.toDouble() / arr.size
    }
}