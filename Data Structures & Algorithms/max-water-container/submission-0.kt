class Solution {
    fun maxArea(heights: IntArray): Int {
        var result = 0
        var start = 0
        var end = heights.size-1
        while(start<end){
            result = max(result,min(heights[start],heights[end])*(end-start))
            if(heights[start]<=heights[end]){
                start++
            }else {
                end--
            }
        }
        return result
    }
}
