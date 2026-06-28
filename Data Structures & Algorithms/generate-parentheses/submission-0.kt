class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        val s = StringBuilder()
        fun backTrack(opn:Int, cls:Int){
            if(opn==n && cls==n){
                result.add(s.toString())
                return
            }
            if(opn<n){
                s.append('(')
                backTrack(opn+1,cls)
                s.deleteCharAt(s.length-1)
            }
            if(cls<opn){
                s.append(')')
                backTrack(opn,cls+1)
                s.deleteCharAt(s.length-1)
            }
        }
        backTrack(0,0)
        return result
    }
}
