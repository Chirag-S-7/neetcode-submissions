/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {

        fun same(a: TreeNode?, b: TreeNode?): Boolean {

            if (a == null && b == null) return true
            if (a == null || b == null) return false

            if (a.`val` != b.`val`) return false

            return same(a.left, b.left) &&
                   same(a.right, b.right)
        }

        fun dfs(node: TreeNode?): Boolean {

            if (node == null) return false

            if (same(node, subRoot)) return true

            return dfs(node.left) || dfs(node.right)
        }

        return dfs(root)
    }
}
