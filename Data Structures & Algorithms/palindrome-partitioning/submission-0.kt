class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val curr = mutableListOf<String>()
        fun solve(i:Int){
            if(i==s.length){
                result.add(curr.toList())
                return
            }
            for(index in i until s.length){
                if (isPalindrome(s, i, index)) {
                    curr.add(s.substring(i, index + 1))
                    solve(index + 1)
                    curr.removeAt(curr.lastIndex)
                }
            }
        }
        solve(0)
        return result
    }
    fun isPalindrome(s:String,start:Int,end:Int):Boolean {
        var st = start
        var ed = end
        while(st<=ed){
            if(s[st]!=s[ed]){
                return false
            }
            st++
            ed--
        }
        return true
    }
}
