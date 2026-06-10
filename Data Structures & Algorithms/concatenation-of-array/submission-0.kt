class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val n = nums.size
        val arr = IntArray(2*n)
        for(i in nums.indices){
            arr[i]=nums[i]
            arr[i+n]=nums[i]
        }
        return arr
    }
}
