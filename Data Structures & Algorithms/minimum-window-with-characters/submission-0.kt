class Solution {
    fun minWindow(s: String, t: String): String {
        if(t.isEmpty()) return ""
        val mp1 = mutableMapOf<Char,Int>()
        val mp2 = mutableMapOf<Char,Int>()
        for(ch in t){
            mp1[ch] = mp1.getOrDefault(ch,0)+1
        }
        var curr = 0
        var need = mp1.size
        var idx = -1
        var start = 0
        var len = Int.MAX_VALUE
        for(end in s.indices){
            val ch = s[end]
            mp2[ch] = mp2.getOrDefault(ch,0)+1
            if(mp1.containsKey(ch) && mp2[ch]==mp1[ch]){
                curr++
            }
            while(curr==need){
                if(end-start+1 < len){
                    len = end-start+1
                    idx = start
                }
                mp2[s[start]] = mp2.getOrDefault(s[start],0) - 1
                if(mp1.containsKey(s[start]) && mp2[s[start]] ?: 0 < mp1[s[start]] !!){
                    curr--
                }
                start++
            }
        }
        return if(idx==-1) "" else s.substring(idx,idx+len)
    }
}
