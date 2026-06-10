class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) {
            return false
        }
        val mp = sortedMapOf<Int, Int>()
        for (num in hand) {
            mp[num] = mp.getOrDefault(num, 0) + 1
        }
        for (num in mp.keys.toList()) {
            val count = mp[num]!!
            if (count > 0) {
                for (i in 0 until groupSize) {
                    val current = num + i
                    if (mp.getOrDefault(current, 0) < count) {
                        return false
                    }
                    mp[current] = mp[current]!! - count
                }
            }
        }
        return true
    }
}

