class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2){ - 1 }
        var start = 0
        var end = numbers.size-1
        while(start<end){
            if(numbers[start]+numbers[end]==target && numbers[start]!=numbers[end]){
                result[0] = start+1
                result[1]= end+1
                return result
            } else if(numbers[start]+numbers[end] < target) {
                start++
            } else {
                end--
            }
        }
        return result
    }
}
