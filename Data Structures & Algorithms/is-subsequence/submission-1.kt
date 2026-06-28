class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if(s.length>t.length) return false
        if(s.isEmpty()) return true
        var idx = 0
        for(ch in t){
            if(ch==s[idx]){
                idx++
            }
            if(idx==s.length) return true
        }
        return false
    }
}
