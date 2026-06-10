class TimeMap() {

    private val mp = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {

        mp.getOrPut(key) { mutableListOf() }
            .add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {

        if (!mp.containsKey(key)) {
            return ""
        }

        val list = mp[key]!!

        var left = 0
        var right = list.size - 1

        var result = ""

        while (left <= right) {

            val mid = left + (right - left) / 2

            if (list[mid].first <= timestamp) {

                result = list[mid].second
                left = mid + 1

            } else {

                right = mid - 1
            }
        }

        return result
    }
}
