class Solution {
    fun numRescueBoats(arr: IntArray, t: Int): Int {
        arr.sort()
        var start = 0
        var end = arr.size-1
        var result = 0
        while(start<=end){
            if(arr[start]+arr[end]<=t){
                start++  
            } 
            end--
            result++
        }
        return result
    }
}
