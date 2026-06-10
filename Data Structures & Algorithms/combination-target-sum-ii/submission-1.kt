class Solution {

    fun combinationSum2(nums: IntArray, target: Int): List<List<Int>> {

        nums.sort()

        val result = mutableListOf<List<Int>>()
        val curr = mutableListOf<Int>()

        fun backtrack(start: Int, target: Int) {

            if (target == 0) {
                result.add(curr.toList())
                return
            }

            if (target < 0) return

            for (i in start until nums.size) {

                if (i > start && nums[i] == nums[i - 1]) {
                    continue
                }

                if (nums[i] > target) break

                curr.add(nums[i])

                backtrack(i + 1, target - nums[i])

                curr.removeAt(curr.lastIndex)
            }
        }

        backtrack(0, target)

        return result
    }
}