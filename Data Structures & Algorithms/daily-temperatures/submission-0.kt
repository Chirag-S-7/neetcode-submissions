class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val stack = ArrayDeque<Int>()
        val result = IntArray(n){ 0 }
        stack.addLast(n-1)
        var i = n-2
        while(i>=0){
            while(stack.isNotEmpty() && temperatures[stack.last()!!] <= temperatures[i]){
                stack.removeLast()
            }
            if(stack.isNotEmpty()){
                result[i]=stack.last()!! - i
            } 
            stack.addLast(i)
            i--
        }
        return result
    }
}
