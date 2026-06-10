class MyStack() {
    val q1 = ArrayDeque<Int>()
    val q2 = ArrayDeque<Int>()
    fun push(x: Int) {
        while(q1.isNotEmpty()){
            q2.addLast(q1.removeFirst())
        }
        q1.addLast(x)
        while(q2.isNotEmpty()){
            q1.addLast(q2.removeFirst())
        }
    }

    fun pop(): Int {
        return q1.removeFirst()
    }

    fun top(): Int {
        return q1.first()
    }

    fun empty(): Boolean {
        return q1.isEmpty()
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */
