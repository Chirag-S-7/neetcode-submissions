class Solution {
    fun maxArea(heights: IntArray): Int {
        var result = Int.MIN_VALUE
        var left = 0
        var right = heights.size - 1
        while(left<=right){
            val area = min(heights[left],heights[right])*(right-left)
            result = max(result,area)
            if(heights[left]<heights[right]){
                left++
            } else {
                right --
            }
        }
        return result
    }
}
