class Solution {
    fun isHappy(n: Int): Boolean {
        fun digitSquareSum(n:Int):Int{
            var curr = n
            var sum = 0
            while(curr>0){
                val d = curr%10
                sum+=(d*d)
                curr/=10
            }
            return sum
        }
        var slow=n
        var fast=digitSquareSum(n)
        while(fast!=slow){
            slow=digitSquareSum(slow)
            fast=digitSquareSum(digitSquareSum(fast))
        }
        return fast==1
    }
}
