class Solution {
    fun isValid(s: String): Boolean {
        val mp = mapOf(
            ']' to '[',
            '}' to '{',
            ')' to '('
        )
        val st = ArrayDeque<Char>()
        for(ch in s){
            when(ch){
                '[','{','(' -> st.addFirst(ch)
                else -> {
                    if(mp[ch]!=st.peek()) return false
                    st.removeFirst()
                }
            }
        }
        return st.isEmpty()
    }
}
