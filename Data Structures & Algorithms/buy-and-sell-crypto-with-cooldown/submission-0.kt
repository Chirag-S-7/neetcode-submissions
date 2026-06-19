class Solution {
    fun maxProfit(prices: IntArray): Int {
        val dp = HashMap<Pair<Int, Boolean>, Int>()

        fun dfs(i: Int, buying: Boolean): Int {
            if (i >= prices.size) return 0

            val key = Pair(i, buying)
            if (key in dp) return dp[key]!!

            val cooldown = dfs(i + 1, buying)
            dp[key] = if (buying) {
                val buy = dfs(i + 1, false) - prices[i]
                maxOf(buy, cooldown)
            } else {
                val sell = dfs(i + 2, true) + prices[i]
                maxOf(sell, cooldown)
            }

            return dp[key]!!
        }

        return dfs(0, true)
    }
}
