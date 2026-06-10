class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = mutableListOf<Pair<Int, Double>>()

        for (i in position.indices) {
            val time = (target - position[i]).toDouble() / speed[i]
            cars.add(position[i] to time)
        }
        cars.sortByDescending { it.first }

        var fleets = 0
        var maxTime = 0.0

        for ((_, time) in cars) {
            if (time > maxTime) {
                fleets++
                maxTime = time
            }
        }

        return fleets
    }
}
