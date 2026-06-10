/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        fun helper(root:TreeNode?) : Int{
            if(root==null) return 0
            return 1+max(helper(root.left),helper(root.right))
        }
        return helper(root)
    }
}
