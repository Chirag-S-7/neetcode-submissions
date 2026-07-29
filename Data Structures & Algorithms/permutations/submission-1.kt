class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val n = nums.size
        fun backTrack(idx:Int){
            if(idx==n){
                result.add(nums.toList())
                return
            }
            for(i in idx until n){
                nums[i] = nums[idx].also{ nums[idx]=nums[i]}
                backTrack(idx+1)
                nums[i] = nums[idx].also{ nums[idx]=nums[i]}
            }
        }
        backTrack(0)
        return result
    }
}
