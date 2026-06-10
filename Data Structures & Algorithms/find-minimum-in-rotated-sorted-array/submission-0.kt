class Solution {
    fun findMin(nums: IntArray): Int {
        var start = 0
        var end = nums.size-1
        while(start<end){
            val mid = (end-start)/2+start
            if(nums[mid]>nums[end]){
                start=mid+1
            } else {
                end = mid
            }
        }
        return nums[end]
    }
}
