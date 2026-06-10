class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size-1
        while(start<=end){
            val mid = (end-start)/2 + start
            when {
                nums[mid]==target -> return mid
                nums[mid]<target -> start = mid+1
                nums[mid]> target -> end = mid-1
            }
        }
        return -1
    }
}
