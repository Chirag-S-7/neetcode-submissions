class Solution {
    fun searchInsert(nums: IntArray, t: Int): Int {
        var start = 0
        var end = nums.size
        while(start<end){
            val mid = start+(end-start)/2
            if(nums[mid]>=t){
                end=mid
            } else {
                start = mid+1
            }
        }
        return start 
    }
}
