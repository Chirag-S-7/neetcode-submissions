import java.util.PriorityQueue

class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val maxHeap = PriorityQueue<Pair<Int, Char>>(compareByDescending { it.first })

        if (a > 0) maxHeap.add(a to 'a')
        if (b > 0) maxHeap.add(b to 'b')
        if (c > 0) maxHeap.add(c to 'c')

        val result = StringBuilder()

        while (maxHeap.isNotEmpty()) {
            if (result.length < 2) {
                val curr = maxHeap.poll()
                result.append(curr.second)
                if (curr.first - 1 > 0) {
                    maxHeap.add(curr.first - 1 to curr.second)
                }
            } else {
                val curr = maxHeap.poll()

                val last = result[result.length - 1]
                val secondLast = result[result.length - 2]

                if (curr.second == last && curr.second == secondLast) {
                    if (maxHeap.isEmpty()) {
                        return result.toString()
                    }

                    val next = maxHeap.poll()

                    result.append(next.second)

                    if (next.first - 1 > 0) {
                        maxHeap.add(next.first - 1 to next.second)
                    }

                    maxHeap.add(curr)
                } else {
                    result.append(curr.second)

                    if (curr.first - 1 > 0) {
                        maxHeap.add(curr.first - 1 to curr.second)
                    }
                }
            }
        }

        return result.toString()
    }
}
