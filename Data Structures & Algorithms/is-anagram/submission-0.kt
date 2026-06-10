class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        val freqArray = IntArray(26)
        for(i in 0 until s.length){
            freqArray[s[i]-'a']++
            freqArray[t[i]-'a']--
        }
        for(ele in freqArray){
            if(ele != 0) return false 
        }
        return true
    }
}
