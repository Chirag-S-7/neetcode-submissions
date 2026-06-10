class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val currList = mutableListOf<Int>()
        val n = nums.size
        fun backTrack(i:Int, target : Int){
            if(target<0){
                return 
            }
            if(i==n){
                if(target==0){
                    result.add(currList.toList())
                }
                return
            }
            currList.add(nums[i])
            backTrack(i,target-nums[i])
            currList.removeAt(currList.lastIndex)
            backTrack(i+1,target)
        }
        backTrack(0,target)
        return result
    }
}
