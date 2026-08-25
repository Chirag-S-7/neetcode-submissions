class Solution {
    fun minimumIndex(nums: List<Int>): Int {
        val freqMap = mutableMapOf<Int,Int>()
        var mxCount = 0
        var mxEle = -1
        val len = nums.size
        for(ele in nums){
            freqMap[ele] = freqMap.getOrDefault(ele,0)+1
            if(mxCount<freqMap[ele]!!){
                mxCount = freqMap[ele]!!
                mxEle = ele 
            }
        }
    
        var currCount = 0
        for(i in nums.indices){
            if(nums[i]==mxEle){
                currCount++
                if(currCount>=(i+1)/2 + 1 && 
                (mxCount-currCount) >= (len-i-1)/2 + 1){
                    return i
                }
            }
        }
        return -1
    }
}