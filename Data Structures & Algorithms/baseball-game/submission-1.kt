class Solution {
    fun calPoints(operations: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (op in operations) {
            when (op) {

                "+" -> {
                    val last = stack.removeLast()
                    val secondLast = stack.last()

                    stack.addLast(last)
                    stack.addLast(last + secondLast)
                }

                "D" -> {
                    stack.addLast(stack.last() * 2)
                }

                "C" -> {
                    stack.removeLast()
                }

                else -> {
                    stack.addLast(op.toInt())
                }
            }
        }

        return stack.sum()
    }
}