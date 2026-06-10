class Solution {
    companion object {
        private const val MAX_CHAR = 26
    }
    
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        fun hash(s:String):String {
            val freqMap = IntArray(MAX_CHAR){0}
            for(ch in s){
                freqMap[ch-'a']++
            }
            var hash = ""
            for(key in freqMap){
                hash+="${key}$"
            }
            return hash
        }
        val anagrams = mutableMapOf<String,MutableList<String>>()
        for(s in strs){
            val hash = hash(s)
            if(anagrams.containsKey(hash)){
                anagrams[hash]!!.add(s)
            } else {
                anagrams[hash] = mutableListOf<String>()
                anagrams[hash]!!.add(s)
            }
        }
        val result = mutableListOf<List<String>>()
        for(value in anagrams.values){
            result.add(value.toList())
        }
        return result.toList()
    }
}
