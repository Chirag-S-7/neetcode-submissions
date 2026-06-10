/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun helper(root:TreeNode?) : Int {
        if(root==null) return 0
        return 1+max(helper(root.left),helper(root.right))
    }
    fun isBalanced(root: TreeNode?): Boolean {
        if(root==null) return true
        val left = helper(root.left)
        val right = helper(root.right)
        if(abs(left-right)>1) return false
        return isBalanced(root.left) && isBalanced(root.right)
    }
}
