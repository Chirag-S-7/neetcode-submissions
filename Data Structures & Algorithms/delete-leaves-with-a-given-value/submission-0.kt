/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        if(root==null) return root
        if(root.`val`==target && root.left==null && root.right==null) return null
        fun dfs(root:TreeNode?,prev:TreeNode,isLeft:Boolean=true){
            if(root==null) return 
            dfs(root.left,root,true)
            if(root.`val`==target && root.left==null && root.right==null){
                if(isLeft){
                    prev.left=null
                } else {
                    prev.right=null
                }
            }
            dfs(root.right,root,false)
        }
        dfs(root,root)
        if(root.`val`==target && root.left==null && root.right==null) return null
        return root
    }
}
