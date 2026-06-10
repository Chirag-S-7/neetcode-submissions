class Solution {

    fun validPalindrome(s: String): Boolean {

        fun isPalindrome(left: Int, right: Int): Boolean {
            var l = left
            var r = right

            while (l < r) {
                if (s[l] != s[r]) {
                    return false
                }
                l++
                r--
            }

            return true
        }

        var start = 0
        var end = s.length - 1

        while (start < end) {

            if (s[start] != s[end]) {

                return isPalindrome(start + 1, end) ||
                       isPalindrome(start, end - 1)
            }

            start++
            end--
        }

        return true
    }
}