/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        fun helper(root:TreeNode?, min:Int,max:Int):Boolean{
            if(root==null) return true
            if(root.`val`>= max || root.`val`<= min) return false
            return helper(root?.left,min,root.`val`) &&
                   helper(root?.right,root.`val`,max) 
        }
        return helper(root,-1001,1001)
    }
}
