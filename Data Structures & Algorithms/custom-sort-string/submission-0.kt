class Solution {
    fun customSortString(order: String, s: String): String {
        val mp = HashMap<Char,Int>()
        for(i in 0 until order.length){
            mp[order[i]]=i
        }
        return s.toCharArray()
            .sortedBy { mp.getOrDefault(it, 26) }
            .joinToString("")
    }
}
