/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun inorder(root:TreeNode?){
            if(root==null) return 
            inorder(root.left)
            result.add(root.`val`)
            inorder(root.right)
        }
        inorder(root)
        return result 
    }
}
