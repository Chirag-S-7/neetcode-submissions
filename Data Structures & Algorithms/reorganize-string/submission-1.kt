class Solution {
    fun reorganizeString(s: String): String {
        val len = s.length
        val mp = IntArray(26)
        for(ch in s){
            mp[ch-'a']++
            if(mp[ch-'a']>(len + 1) / 2) return ""
        }
        var pq = PriorityQueue<Pair<Char,Int>>{ a, b ->
            b.second - a.second
        }
        for(i in 0 until 26){
            if(mp[i]!=0){
                pq.add(('a'+i) to mp[i])
            }
        }
        val sb = StringBuilder()
        while(pq.isNotEmpty()){
            val top = pq.poll()
            if(sb.isNotEmpty() && top.first==sb[sb.length-1]){
                if (pq.isEmpty()) return ""
                val sTop = pq.poll()
                sb.append(sTop.first)
                if(sTop.second-1 > 0){
                    pq.add(sTop.first to sTop.second-1)
                }
                pq.add(top)
            } else {
                sb.append(top.first)
                if(top.second-1 > 0){
                    pq.add(top.first to top.second-1)
                }
            }
        }
        return sb.toString()
    }
}
