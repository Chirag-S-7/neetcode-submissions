class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var end = numbers.size-1
        while(start<end){
            val sum = numbers[start]+numbers[end]
            when {
                sum == target && numbers[start]!=numbers[end] -> return intArrayOf(start+1, end+1)
                sum > target -> end -- 
                else -> start ++ 
            }
        }
        return intArrayOf()
    }
}
