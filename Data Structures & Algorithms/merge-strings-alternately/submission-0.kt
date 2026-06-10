class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val s = StringBuilder()
        var i = 0
        while(i<word1.length && i<word2.length){
            s.append(word1[i])
            s.append(word2[i])
            i++
        }
        while(i<word1.length){
            s.append(word1[i])
            i++
        }
        while(i<word2.length){
            s.append(word2[i])
            i++
        }
        return s.toString()
    }
}
