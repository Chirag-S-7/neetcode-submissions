class StockSpanner() {
    private val l = mutableListOf<Int>()
    fun next(price: Int): Int {
        var count = 1
        val n = l.size
        for(i in n-1 downTo 0){
            if(l[i]>price) break
            count++
        }
        l.add(price)
        return count
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * val obj = StockSpanner()
 * val param_1 = obj.next(price)
 */
