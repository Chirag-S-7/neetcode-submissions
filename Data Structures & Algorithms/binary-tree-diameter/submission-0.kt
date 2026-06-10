/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var res = 0
        fun helper(root:TreeNode?):Int{
            if(root==null) return 0
            res = max(res,helper(root.left)+helper(root.right))
            return 1+max(helper(root.left),helper(root.right))
        }
        helper(root)
        return res
    }
}
