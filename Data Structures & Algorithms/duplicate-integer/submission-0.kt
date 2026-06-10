class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val mp = mutableMapOf<Int,Boolean>()
        for(ele in nums){
            if(mp.containsKey(ele)){
                return true
            }
            mp[ele] = true
        }
        return false
    }
}
