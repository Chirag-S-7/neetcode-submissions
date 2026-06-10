/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        fun invert(root:TreeNode?) {
            if(root==null) return
            val left = root.left
            root.left=root.right
            root.right = left
            invert(root.left)
            invert(root.right)
        }
        invert(root)
        return root
    }
}
