class Solution {
    fun foreignDictionary(words: Array<String>): String {
        val mp = mutableMapOf<Char, MutableList<Char>>()
        val n = words.size
        for (i in 0 until n - 1) {
            val w1 = words[i]
            val w2 = words[i + 1]
             if (w1.length > w2.length && w1.startsWith(w2)) {
                return ""
            }
            for (k in 0 until minOf(w1.length, w2.length)) {
                if (w1[k] != w2[k]) {
                    mp.getOrPut(w1[k]) { mutableListOf() }
                        .add(w2[k])
                    break
                }
            }
        }
        val result=StringBuilder() 
        val indegree = mutableMapOf<Char, Int>()
        for (word in words) {
            for (ch in word) {
                indegree.putIfAbsent(ch, 0)
            }
        }

        for ((_, neighbors) in mp) {
            for (ch in neighbors) {
                indegree[ch] = indegree.getOrDefault(ch, 0) + 1
            }
        }
        val q = ArrayDeque<Char>()
        for((k,v) in indegree){
            if(indegree[k]==0){
                q.addLast(k)
            }
        }
        var cnt = 0
        while(q.isNotEmpty()){
            val ch = q.removeFirst()
            cnt++
            result.append(ch)
            val neighbors = mp[ch] ?: emptyList()
            for(ele in neighbors){
                indegree[ele] = indegree[ele]!!-1
                if(indegree[ele]==0){
                    q.addLast(ele)
                }
            }
        }
        return if(cnt==indegree.size) result.toString() else "" 
    }
}
