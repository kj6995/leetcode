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
    fun maxDepth(root: TreeNode?): Int {
        if(root == null){
            return 0
        }
        
        var ldepth = maxDepth(root.left)
        var rdepth = maxDepth(root.right)
        
        if(ldepth >= rdepth){
            return ldepth+1
        }else{
            return rdepth+1
        }
    }
}