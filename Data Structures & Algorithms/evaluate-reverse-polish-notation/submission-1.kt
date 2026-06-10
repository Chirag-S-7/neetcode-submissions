class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val st = ArrayDeque<Int>()
        var result = 0
        for(t in tokens){
            when(t){
                "+"->{
                    val f = st.removeFirst()
                    val s = st.removeFirst()
                    st.addFirst(f+s)
                }
                "-"->{
                    val f = st.removeFirst()
                    val s = st.removeFirst()
                    st.addFirst(s-f)
                }
                "*"->{
                    val f = st.removeFirst()
                    val s = st.removeFirst()
                    st.addFirst(f*s)
                }
                "/"->{
                    val f = st.removeFirst()
                    val s = st.removeFirst()
                    st.addFirst(s/f)
                }
                else->{
                    st.addFirst(t.toInt())
                }
            }
        }
        return st.first()
    }
}
