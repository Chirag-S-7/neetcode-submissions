/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun postOrder(root:TreeNode?){
            if(root==null) return 
            postOrder(root.left)
            postOrder(root.right)
            result.add(root.`val`)
        }
        postOrder(root)
        return result 
    }
}
