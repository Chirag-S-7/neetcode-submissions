class FreqStack() {
    private val cnt = mutableMapOf<Int, Int>()
    private val stacks = mutableListOf(mutableListOf<Int>())

    fun push(`val`: Int) {
        val valCnt = cnt.getOrDefault(`val`, 0) + 1
        cnt[`val`] = valCnt
        if (valCnt == stacks.size) {
            stacks.add(mutableListOf())
        }
        stacks[valCnt].add(`val`)
    }

    fun pop(): Int {
        val lastStack = stacks.last()
        val res = lastStack.removeLast()
        cnt[res] = cnt[res]!! - 1
        if (lastStack.isEmpty()) {
            stacks.removeLast()
        }
        return res
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * val obj = FreqStack()
 * obj.push(`val`)
 * val param_2 = obj.pop()
 */
