class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val curr = mutableListOf<Int>()
        val n = nums.size
        fun backTrack(i:Int,curr:MutableList<Int>,pick: BooleanArray){
            if(i==n){
                result.add(curr.toList())
                return
            }
            for(j in nums.indices){
                if(!pick[j]){
                    curr.add(nums[j])
                    pick[j] = true
                    backTrack(i+1,curr,pick)
                    curr.removeAt(curr.size-1)
                    pick[j]=false
                }
                
            }
        }
        backTrack(0,curr,BooleanArray(nums.size))
        return result
    }
}
