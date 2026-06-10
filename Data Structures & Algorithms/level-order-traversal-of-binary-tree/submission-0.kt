/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val q = ArrayDeque<TreeNode>()
        val result = mutableListOf<List<Int>>()
        if(root==null) return result
        q.addLast(root)
        while(q.isNotEmpty()){
            val len = q.size
            val curr = mutableListOf<Int>()
            repeat(len){
                val node = q.removeFirst()
                curr.add(node.`val`)
                node.left?.let{
                    q.addLast(it)
                }
                node.right?.let{
                    q.addLast(it)
                }
            }
            result.add(curr.toList())
        }
        return result
    }
}
