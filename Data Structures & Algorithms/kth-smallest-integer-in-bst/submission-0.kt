/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var x = k
        var result = -1
        fun inOrder(root:TreeNode?){
            if(root==null) return
            inOrder(root?.left)
            x--
            if(x==0) {
                result = root.`val`
            }
            inOrder(root?.right)
        }
        inOrder(root)
        return result

    }
}
