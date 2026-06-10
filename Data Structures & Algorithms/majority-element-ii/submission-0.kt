class Solution {
//Generalized n/k
    fun majorityElement(nums: IntArray): List<Int> {
        val count = mutableMapOf<Int, Int>()
        for (num in nums) {
            count[num] = count.getOrDefault(num, 0) + 1
            if (count.size == 3) {
                val keys = count.keys.toList()
                for (key in keys) {
                    count[key] = count[key]!! - 1
                    if (count[key] == 0) {
                        count.remove(key)
                    }
                }
            }
        }
        val actualCount = mutableMapOf<Int, Int>()

        for (num in nums) {
            if (count.containsKey(num)) {
                actualCount[num] = actualCount.getOrDefault(num, 0) + 1
            }
        }

        val result = mutableListOf<Int>()
        for ((num, freq) in actualCount) {
            if (freq > nums.size / 3) {
                result.add(num)
            }
        }

        return result
    }
}
