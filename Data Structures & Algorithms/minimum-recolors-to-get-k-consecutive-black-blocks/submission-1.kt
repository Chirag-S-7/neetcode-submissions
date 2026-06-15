class Solution {
    fun minimumRecolors(s: String, k: Int): Int {
        var result = k
        var w = 0
        var b = 0
        var start = 0
        for(end in 0 until s.length){
            if(s[end]=='W'){
                w++
            } else {
                b++
            }
            if(end-start+1==k){
                result=min(w,result)
                if(s[start]=='W') w--
                else b--
                start++

            }
        }
        return result
    }
}
