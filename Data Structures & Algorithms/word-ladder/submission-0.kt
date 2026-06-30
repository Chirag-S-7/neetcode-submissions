class Solution {
    fun ladderLength(b: String, e: String, w: MutableList<String>): Int {
        if(!w.contains(e) || b.length!=e.length || b == e) return 0
        var start = b
        val q = ArrayDeque<String>()
        q.add(start)
        val words = w.toMutableSet()
        words.remove(b)
        var level = 1
        while(q.isNotEmpty()){
            repeat(q.size){
                val curr = q.removeFirst()
                if(curr==e){
                    return level
                }
                for(i in curr.indices){
                    for(c in 'a'..'z'){
                        if (curr[i] == c) {
                            continue
                        }
                        val nei = curr.substring(0, i) + c + curr.substring(i + 1)
                        if (words.remove(nei)) {
                            q.add(nei)
                        }
                    }
                }
            }
            level++
        }
        return 0
    }
}
