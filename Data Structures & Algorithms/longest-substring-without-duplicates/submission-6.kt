class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val mp = mutableMapOf<Char,Int>()
        var start = 0
        var ans = 0
        for(end in s.indices){
            if(mp.containsKey(s[end])){
                start = max(start,mp[s[end]]!!+1)
            }
            mp[s[end]]=end
            ans = max(ans,end-start+1)
        }
        return ans
    }
}
