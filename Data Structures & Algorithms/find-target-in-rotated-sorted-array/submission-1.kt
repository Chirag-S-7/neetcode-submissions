class Solution {
    fun search(nums: IntArray, t: Int): Int {
        var start = 0
        var end = nums.size-1
        while(start<=end){
            val mid = start + (end-start)/2
            if(nums[mid]==t){
                return mid
            } 
            if(nums[start]<=nums[mid]){
                if(nums[start]<=t && t<nums[mid]){
                    end = mid-1
                } else {
                    start = mid+1
                }
            } else {
                if(nums[mid]<t && t<=nums[end]){
                    start = mid+1
                } else {
                    end = mid-1
                }
            }
        }
        return -1
    }
}
