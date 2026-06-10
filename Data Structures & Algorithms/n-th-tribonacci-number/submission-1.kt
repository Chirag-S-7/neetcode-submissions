class Solution {
    fun tribonacci(n: Int): Int {
        if(n<=1) return n
        if(n==2) return 1 
        var zero = 0
        var one = 1
        var two = 1
        var result = 0
        for(i in 3..n){
            result = zero+one+two
            zero = one
            one = two
            two = result
        }
        return result
    }
}
