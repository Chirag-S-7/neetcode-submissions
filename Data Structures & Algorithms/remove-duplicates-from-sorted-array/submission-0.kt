class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var nonRepeatingIndex = 0
        for(i in 1 until nums.size){
            if(nums[i]!=nums[i-1]){
                nonRepeatingIndex++
                nums[nonRepeatingIndex] = nums[i]
            }
        }
        return nonRepeatingIndex+1
    }
}
