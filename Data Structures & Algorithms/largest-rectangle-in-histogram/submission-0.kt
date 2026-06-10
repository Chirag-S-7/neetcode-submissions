class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val n = heights.size
        val prevSmall = IntArray(n) { -1 }
        val nextSmall = IntArray(n) { n }
        val st = ArrayDeque<Int>()
        for (i in 0 until n) {
            while (st.isNotEmpty() && heights[st.last()] >= heights[i]) {
                st.removeLast()
            }
            if (st.isNotEmpty()) {
                prevSmall[i] = st.last()
            }
            st.addLast(i)
        }
        st.clear()
        for (i in n - 1 downTo 0) {
            while (st.isNotEmpty() && heights[st.last()] >= heights[i]) {
                st.removeLast()
            }
            if (st.isNotEmpty()) {
                nextSmall[i] = st.last()
            }
            st.addLast(i)
        }

        var result = 0

        for (i in 0 until n) {
            val width = nextSmall[i] - prevSmall[i] - 1
            val area = width * heights[i]
            result = maxOf(result, area)
        }

        return result
    }
}
