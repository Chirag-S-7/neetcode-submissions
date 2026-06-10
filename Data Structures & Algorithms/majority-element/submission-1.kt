class Solution {
    fun majorityElement(nums: IntArray): Int {
        var result = nums[0]
        var count=1
        for(i in 1 until nums.size){
            if(count==0){
                result=nums[i]
            }
            count += if (nums[i] == result) 1 else -1
        }
        return result
    }
}
