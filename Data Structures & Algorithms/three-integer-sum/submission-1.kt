class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val n = nums.size-1
        val result = mutableListOf<List<Int>>()
        for(i in 0 until n){
            if(i>0 && nums[i]==nums[i-1]) continue
            val curr = nums[i]
            var j = i+1
            var k = n
            while(j<k){
                when {
                    curr+nums[j]+nums[k] == 0 -> {
                        result.add(
                            listOf(nums[i], nums[j], nums[k])
                        )
                        j++
                        k--

                        while(j<k && nums[j]==nums[j-1]) j++
                        while(k>j && nums[k]==nums[k+1]) k-- 
                    }
                    curr+nums[j]+nums[k] > 0 -> {
                        k--
                    } 
                    curr+nums[j]+nums[k] < 0 -> {
                        j++
                    }
                }
            }
        }
        return result
    }
}
