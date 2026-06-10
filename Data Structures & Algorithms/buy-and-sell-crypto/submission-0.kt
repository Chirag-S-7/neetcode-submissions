class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = prices[0]
        var maxProfit = 0
        for(i in 1 until prices.size){
            minPrice = min(minPrice,prices[i])
            maxProfit = max(maxProfit,prices[i]-minPrice)
        }
        return maxProfit
    }
}
