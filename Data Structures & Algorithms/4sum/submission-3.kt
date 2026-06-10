class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        val n = nums.size

        for (i in 0 until n) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            for (j in i + 1 until n) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue

                var left = j + 1
                var right = n - 1
                while (left < right) {
                    val sum = nums[i].toLong() + nums[j] + nums[left] + nums[right]
                    when {
                        sum == target.toLong() -> {
                            res.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                            left++
                            right--
                            while (left < right && nums[left] == nums[left - 1]) left++
                            while (left < right && nums[right] == nums[right + 1]) right--
                        }
                        sum < target -> left++
                        else -> right--
                    }
                }
            }
        }

        return res
    }
}