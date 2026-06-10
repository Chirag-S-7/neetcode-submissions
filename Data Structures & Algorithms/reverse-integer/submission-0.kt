class Solution {
    fun reverse(x: Int): Int {
        if(x>Int.MAX_VALUE || x<Int.MIN_VALUE) return 0
        val negative = x<0
        var nx =abs(x)
        var result = 0
        while(nx>0){
            if (result > (Int.MAX_VALUE - nx % 10) / 10) {
                return 0
            }
            val digit = nx%10
            nx/=10
            result = result*10 + digit
        }
        if(negative){
            result = -result
        } 
        return if (result < Int.MIN_VALUE || result > Int.MAX_VALUE) 0 else result
    }
}
