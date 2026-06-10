class Solution {
    fun mySqrt(x: Int): Int {
        if (x < 2) return x
        var start = 1
        var end = x / 2
        var ans = 0

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (mid <= x / mid) {
                ans = mid
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return ans
    }
}
