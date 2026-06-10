class Solution {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()

        for (part in path.split("/")) {
            when (part) {
                "", "." -> {}
                ".." -> if (stack.isNotEmpty()) stack.removeLast()
                else -> stack.addLast(part)
            }
        }

        return "/" + stack.joinToString("/")
    }
}