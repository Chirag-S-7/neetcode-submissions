class Solution {
    fun sortColors(nums: IntArray) {
        var start = 0
        var mid = 0
        var end = nums.size-1
        while(mid<=end){
            when(nums[mid]){
                1-> {mid++}
                0-> { 
                        nums[start] = nums[mid].also { nums[mid] = nums[start]} 
                        mid++
                        start++
                    }
                2-> { 
                        nums[end] = nums[mid].also { nums[mid] = nums[end]} 
                        end--
                 }    
            }
        }
    }
}
