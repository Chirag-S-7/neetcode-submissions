class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val numSet = nums.toHashSet()
        var longest = 0

        for (num in numSet) {
            if (!numSet.contains(num - 1)) {
                var currentNum = num
                var length = 1

                while (numSet.contains(currentNum + 1)) {
                    currentNum++
                    length++
                }

                longest = maxOf(longest, length)
            }
        }

        return longest
    }
}
