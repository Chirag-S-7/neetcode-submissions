class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var high = 0
        var low = -1
        for(w in weights){
            low = max(low,w)
            high+=w
        }
        fun canWeightSuffice(wt:Int):Boolean{
            var curr = 0
            var count = 1
            for(w in weights){
                curr+=w
                if(curr>wt){
                    count++
                    curr=w
                }
            }
            return count<=days
        }

        while(low<high){
            val mid = low+(high-low)/2
            if(canWeightSuffice(mid)){
                high = mid
            } else {
                low = mid+1
            }
        }
        return high 
    }
}
