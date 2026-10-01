class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if(nums.size==0) return 0
        var longest = 0
        var result = 0
        var s = nums.toHashSet()
        for(ele in nums){
            if(!s.contains(ele-1)){
                var currLen = 1
                var currNum = ele
                while(s.contains(currNum+1)){
                    currNum++
                    currLen++
                }
                result = max(result,currLen)
            }
        }
        return result 
    }
}
