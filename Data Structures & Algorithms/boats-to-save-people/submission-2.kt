class Solution {
    fun numRescueBoats(arr: IntArray, t: Int): Int {
        // var mx = arr.maxOrNull()?:0
        // val count = IntArray(mx+1){ 0 }
        // for(ele in arr){
        //     count[ele]++
        // }
        // var idx = 0
        // for(i in 1..mx){
        //     var c = count[i]
        //     while(c!=0){
        //         arr[idx]=i
        //         idx++
        //         c--
        //     }
        // }
        arr.sort()
        var start = 0
        var end = arr.size-1
        var result = 0
        while(start<=end){
            if(arr[start]+arr[end]<=t){
                start++
                end--
            } else {
                end--
            }
            result++
        }
        return result
    }
}
