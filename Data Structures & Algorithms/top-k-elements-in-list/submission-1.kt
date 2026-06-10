class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

    val freqMap = mutableMapOf<Int, Int>()

    nums.forEach {
        freqMap[it] = freqMap.getOrDefault(it, 0) + 1
    }

    val minHeap = PriorityQueue<Pair<Int, Int>>(
        compareBy { it.second }
    )

    freqMap.forEach { (num, freq) ->

        minHeap.offer(num to freq)

        if (minHeap.size > k) {
            minHeap.poll()
        }
    }

        return minHeap.map { it.first }.toIntArray()
    }
}
