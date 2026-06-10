class Solution {
    fun removeElement(nums: IntArray, t: Int): Int {
        var start = 0
        for(ele in nums){
            if(ele!=t){
                nums[start++]=ele
            }
        }
        return start
    }
}
