class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val tails = mutableListOf<Int>()

        for (num in nums) {
            var left = 0
            var right = tails.size

            while (left < right) {
                val mid = left + (right - left) / 2
                if (tails[mid] < num) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }

            if (left == tails.size) {
                tails.add(num)
            } else {
                tails[left] = num
            }
        }

        return tails.size
    }
}
