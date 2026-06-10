class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        fun canEatAllBananasWithKRate(k:Int):Boolean{
            var count = 0
            for(b in piles){
                count+=(b + k - 1) / k
            }
            return count<=h
        }
        var start = 1
        var end = piles.maxOrNull() ?: 0
        while(start<end){
            val mid = (end-start)/2+start
            if(canEatAllBananasWithKRate(mid)){
                end=mid
            } else {
                start=mid+1
            }
        }
        return end
    }
}
