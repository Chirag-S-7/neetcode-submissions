/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    val memo = mutableMapOf<TreeNode,Int>()
    fun rob(root: TreeNode?): Int {
        if(root==null) return 0
        if(memo.containsKey(root)) return memo[root]!!
        val take = root.`val`+ rob(root.left?.left)+ rob(root.left?.right)+ rob(root.right?.left)+ rob(root.right?.right)
        val skip = rob(root.left) + rob(root.right)
        memo[root] = max(take,skip)
        return memo[root]!!
    }
}
