class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {
        val dead = deadends.toHashSet()

        if ("0000" in dead) return -1
        if (target == "0000") return 0

        val q = ArrayDeque<String>()
        q.add("0000")
        dead.add("0000")

        var level = 0

        while (q.isNotEmpty()) {
            repeat(q.size) {
                val lock = q.removeFirst()

                if (lock == target) return level

                for (j in 0..3) {
                    for (move in intArrayOf(1, -1)) {
                        val digit = (lock[j] - '0' + move + 10) % 10
                        val nextLock =
                            lock.substring(0, j) +
                            digit +
                            lock.substring(j + 1)

                        if (nextLock in dead) continue

                        dead.add(nextLock)
                        q.add(nextLock)
                    }
                }
            }
            level++
        }

        return -1
    }
}