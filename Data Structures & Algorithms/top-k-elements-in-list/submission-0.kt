class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val frequentNum = PriorityQueue<Pair<Int, Int>>(
            compareBy<Pair<Int, Int>> { it.second }
        )

        val freqMap = mutableMapOf<Int, Int>()

        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        for ((key, value) in freqMap) {

            if (frequentNum.size < k) {
                frequentNum.offer(Pair(key, value))
            } else {
                val peek = frequentNum.peek()

                if (peek.second < value) {
                    frequentNum.poll()
                    frequentNum.offer(Pair(key, value))
                }
            }
        }

        val result = mutableListOf<Int>()

        for (pair in frequentNum) {
            result.add(pair.first)
        }

        return result.toIntArray()
    }
}
