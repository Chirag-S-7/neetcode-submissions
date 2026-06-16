class Solution {
    fun appendCharacters(s: String, t: String): Int {
        val freq = IntArray(26)
        for(ele in t){
            freq[ele-'a']++
        }
        var start = 0
        for(ch in s){
            if(start<t.length && ch==t[start] && freq[ch-'a']>0){
                start++
                freq[ch-'a']--
            }
        }
        return t.length-start
    }
}
