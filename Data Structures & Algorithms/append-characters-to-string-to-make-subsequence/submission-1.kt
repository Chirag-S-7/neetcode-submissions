class Solution {
    fun appendCharacters(s: String, t: String): Int {
        var l = 0
        var r = 0

        while(l < t.length && r < s.length) {
            if(t[l] == s[r]) l++
            r++
        }

        return t.length - l
    }
}
