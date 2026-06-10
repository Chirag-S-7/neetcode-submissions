/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else {
            if (root.left == null) return root.right
            if (root.right == null) return root.left

            var cur = root.right
            while (cur?.left != null) {
                cur = cur.left
            }
            cur?.left = root.left
            return root.right
        }

        return root
    }
}
