class Solution {
    fun climbStairs(n: Int): Int {
        if(n<=2) return n
        var prev1=2
        var prev2=1
        var result = 0
        for(i in 3..n){
            result = prev1+prev2
            prev2=prev1
            prev1 = result
        }
        return result
    }
}
