class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val mp = mutableMapOf<Int,Int>()
        nums.forEachIndexed{index, num ->
            if(mp.containsKey(num)){
                if(index-mp[num]!!<=k) return true
            }
            mp[num]=index
        }
        return false
    }
}
