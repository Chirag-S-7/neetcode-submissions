class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableSetOf<List<Int>>()
        val curr = mutableListOf<Int>()
        val n = nums.size
        fun backTrack(i:Int,curr:MutableList<Int>){
            if(i==n){
                result.add(curr.toList())
                return
            }
            curr.add(nums[i])
            backTrack(i+1,curr)
            curr.removeAt(curr.size-1)
            var j = i
            while (j + 1 < nums.size && nums[j] == nums[j + 1]) {
                j++
            }
            backTrack(j+1,curr)
        }
        backTrack(0,curr)
        return result.toList()
    }
}
