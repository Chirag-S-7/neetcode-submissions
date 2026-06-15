class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        val n = arr.size
        val suffixMax = IntArray(n)
        suffixMax[n-1]=arr[n-1]
        for(i in n-2 downTo 0){
            suffixMax[i]=max(arr[i+1],suffixMax[i+1])
        }
        suffixMax[n-1]=-1
        return suffixMax
    }
}
