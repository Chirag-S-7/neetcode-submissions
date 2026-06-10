/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val q = ArrayDeque<TreeNode>()
        val result = mutableListOf<Int>()
        if(root==null) return result
        q.addLast(root)
        while(q.isNotEmpty()){
            val len = q.size
            var curr = -1
            repeat(len){
                val node = q.removeFirst()
                curr = node.`val`
                node.left?.let{
                    q.addLast(it)
                }
                node.right?.let{
                    q.addLast(it)
                }
            }
            result.add(curr)
        }
        return result
    }
}
