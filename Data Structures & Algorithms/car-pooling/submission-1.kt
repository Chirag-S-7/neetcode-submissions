class Solution {
    fun carPooling(arr: Array<IntArray>, c: Int): Boolean {
        val n = arr.size
        val nums = Array<Pair<Int,Int>>(2*n){-1 to -1}
        for(i in 0 until n){
            nums[2 * i] = arr[i][1] to arr[i][0]          
            nums[2 * i + 1] = arr[i][2] to -arr[i][0]
        }
        nums.sortWith(
            compareBy<Pair<Int, Int>> { it.first }
                .thenBy { it.second }
        )
        var curr = 0
        for(i in 0 until nums.size){
           curr+=nums[i].second
           if(curr>c) return false
        }
        return true
    }
}
