class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalGas = 0
        var totalCost = 0
        val n = gas.size
        for(i in 0 until n){
            totalGas+=gas[i]
            totalCost+=cost[i]
        }
        if(totalCost > totalGas) return -1
        var start = 0
        var bg = gas[0]
        for(i in 1 until n){
            if(bg-cost[i-1]<0){
                start = i
                bg = gas[i]
            } else {
                bg+=(gas[i]-cost[i-1])
            }
        }
        return start
    }
}
