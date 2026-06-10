class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        var start = 0
        val mp = mutableMapOf<Char,Int>()
        for(end in s.indices){
            if(mp.contains(s[end])){
                start = max(start,mp[s[end]]!! + 1)
            }
            mp[s[end]]=end
            result = max(result,end-start+1)
        }
        return result
    }
}
