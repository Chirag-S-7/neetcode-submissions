/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun preOrder(root:TreeNode?){
            if(root==null) return 
            result.add(root.`val`)
            preOrder(root.left)
            preOrder(root.right)
        }
        preOrder(root)
        return result 
    }
}
