class Solution {
    fun lemonadeChange(arr: IntArray): Boolean {
        var five = 0
        var ten = 0
        for(ele in arr){
            if(ele==5){
                five++
            } else if(ele==10){
                if(five<1) return false
                five--
                ten++
            } else {
                if(five<1 || (ten<1 && five<3)) return false 
                if(ten>0){
                    ten--
                    five--
                } else {
                    five-=3
                }
            }
        }
        return true
    }
}
