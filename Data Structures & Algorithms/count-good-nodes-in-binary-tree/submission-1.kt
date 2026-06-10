/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        if(root==null) return 0
        var result = 1
        fun dfs(root:TreeNode?,mx:Int){
            if(root==null) return
            root.left?.let{
                if(it.`val`>= mx){
                    result++
                }
                dfs(it,maxOf(mx,it.`val`))
            }
            root.right?.let{
                if(it.`val`>= mx){
                    result++
                }
               dfs(it,maxOf(mx,it.`val`))
            }
        }
        dfs(root,root.`val`)
        return result
    }
}
