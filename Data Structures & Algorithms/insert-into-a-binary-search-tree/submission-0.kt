/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun insertIntoBST(root: TreeNode?, t: Int): TreeNode? {
        if(root==null) return TreeNode(t)
        var curr = root
        var prev : TreeNode? = null
        var isLeft = true
        while(curr!=null){
            prev = curr
            if(curr.`val`> t) {
                curr=curr.left
                isLeft = true
            } else {
                curr=curr.right
                isLeft = false
            } 
        }
        if(isLeft) {
            prev?.left = TreeNode(t)
        }else {
            prev?.right = TreeNode(t) 
        }
        return root
    }
}
