class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        var maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

        for (stone in stones) {
            maxHeap.add(stone)
        }

        while (maxHeap.size > 0) {
            val heaviest = maxHeap.poll()
            val secondHeaviest = maxHeap.poll()

            if (secondHeaviest == null) {
                return heaviest
            }


            val diff = heaviest - secondHeaviest
            if (diff > 0) {
                maxHeap.add(diff)
            }
        }

        return 0
    }
}
