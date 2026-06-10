class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum=0
        val n = nums.size
        for(num in nums){
            sum+=num
        }
        val totalSum = (n*(n+1))/2
        return totalSum-sum
    }
}
