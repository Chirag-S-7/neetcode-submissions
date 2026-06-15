class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()

        val result = mutableListOf<List<Int>>()
        val curr = mutableListOf<Int>()
        val n = nums.size

        fun backTrack(i: Int, pick: BooleanArray) {
            if (i == n) {
                result.add(curr.toList())
                return
            }

            for (j in nums.indices) {
                if (pick[j]) continue

                if (j > 0 && nums[j] == nums[j - 1] && !pick[j - 1]) {
                    continue
                }

                curr.add(nums[j])
                pick[j] = true

                backTrack(i + 1, pick)

                pick[j] = false
                curr.removeAt(curr.size - 1)
            }
        }

        backTrack(0, BooleanArray(n))
        return result
    }
}