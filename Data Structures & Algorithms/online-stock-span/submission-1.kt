class StockSpanner() {
    private val stack = ArrayDeque<IntArray>() 
    fun next(price: Int): Int {
        var span = 1
        while (stack.isNotEmpty() && stack.last()[0] <= price) {
            span += stack.removeLast()[1]
        }
        stack.addLast(intArrayOf(price, span))
        return span
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * val obj = StockSpanner()
 * val param_1 = obj.next(price)
 */
