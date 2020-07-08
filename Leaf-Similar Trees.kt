import java.util.Arrays
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        var leaves1: MutableList<Int?> = mutableListOf()
        var leaves2: MutableList<Int?> = mutableListOf()
        dfs(root1, leaves1)
        dfs(root2, leaves2)
        return leaves1.equals(leaves2)
    }

    fun dfs(node: TreeNode?, leafValues: MutableList<Int?>) {
        if (node != null) {
            if (node.left == null && node.right == null) leafValues.add(node.`val`)
            println(leafValues)
            dfs(node.left, leafValues)
            dfs(node.right, leafValues)
        }
    }
}