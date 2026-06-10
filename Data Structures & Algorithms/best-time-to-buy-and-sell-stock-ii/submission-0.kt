class Solution {
    fun maxProfit(arr: IntArray): Int {
        var mn = arr[0]
        var result = 0
        for(i in 1 until arr.size){
            mn=min(mn,arr[i])
            if(arr[i]>mn){
                result+=(arr[i]-mn)
                mn=arr[i]
            }
        }
        return result
    }
}
