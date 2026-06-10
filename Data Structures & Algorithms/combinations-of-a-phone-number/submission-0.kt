class Solution {
    private val map = mapOf<Char,String>(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )
    fun letterCombinations(digits: String): List<String> {
        val n = digits.length
        val result = mutableListOf<String>()
        if(n==0) return result
        val s = StringBuilder()
        fun backTrack(i:Int,s:StringBuilder){
            if(i==n){
                result.add(s.toString())
                return
            }
            val ch = map[digits[i]]!!
            for(j in 0 until ch.length){
                s.append(ch[j])
                backTrack(i+1,s)
                s.deleteCharAt(s.length - 1)
            }
        }
        backTrack(0,s)
        return result
    }
}
