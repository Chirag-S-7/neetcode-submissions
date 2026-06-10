class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var currSum = 0
        val mp = mutableMapOf<Int,Int>()
        var result = 0
        mp[0]=1
        for(n in nums){
            currSum+=n
            if(mp.containsKey(currSum-k)){
                result+=mp[currSum-k]!!
            }
            mp[currSum] = mp.getOrDefault(currSum,0)+1
        }
        return result
    }
}
