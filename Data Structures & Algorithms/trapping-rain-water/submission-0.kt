class Solution {
    fun trap(nums: IntArray): Int {
        val n = nums.size
        var result = 0
        var lMax = nums[0]
        var rMax = nums[n-1]
        var l = 0
        var r = n-1
        while(l<=r){
            if(lMax<rMax){
                lMax = max(lMax,nums[l])
                result+=(lMax-nums[l])
                l++
            } else {
                rMax = max(rMax,nums[r])
                result+=(rMax-nums[r])
                r--
            }
        }
        return result
    }
}
