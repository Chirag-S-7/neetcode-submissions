class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var zeroCount = 0
        var zeroIndex = -1
        var product = 1
        nums.forEachIndexed{ index,n->
            if(n==0){
                zeroCount++
                zeroIndex = index
            } else {
                product*=n
            }
        }
        val result = IntArray(nums.size){0}
        if(zeroCount>1){
            return result
        }
        if(zeroCount==1){
            result[zeroIndex] = product
            return result
        }
        for(i in nums.indices){
            result[i] = product/nums[i]
        }
        return result

    }
}
