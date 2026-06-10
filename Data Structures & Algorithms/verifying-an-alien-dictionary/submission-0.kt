class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val mp = HashMap<Char,Int>()
        for(i in 0 until order.length){
            mp.put(order[i],i)
        }
        for(i in 0 until words.size-1){
            val w1 = words[i]
            val w2 = words[i+1]
            for(j in 0 until w1.length){
                if(j==w2.length) return false
                if(w1[j]!=w2[j]){
                    if(mp[w1[j]]!!>mp[w2[j]]!!) return false
                    break
                } 
            }
        }
        return true
    }
}
