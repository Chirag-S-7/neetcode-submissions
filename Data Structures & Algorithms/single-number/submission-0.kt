class Solution {
    fun singleNumber(nums: IntArray): Int {
        var missing = 0
        for(num in nums){
            missing = missing xor num
        }
        return missing 
    }
}
