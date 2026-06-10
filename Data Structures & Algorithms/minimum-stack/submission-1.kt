class MinStack() {

    val s = ArrayDeque<Pair<Int,Int>>()
    fun push(`val`: Int) {
        val mn = if(s.isEmpty()) `val` else min(s.last().second, `val`)
        s.addLast(`val` to mn)
    }

    fun pop() {
        s.removeLast()
    }

    fun top(): Int {
        return s.last().first
    }

    fun getMin(): Int {
        return s.last().second
    }
}
