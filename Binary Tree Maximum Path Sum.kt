/*
Note: Take a variable and store what's the left sum and right sum and the current node value. Though while returning we take the max of te either the left path or the right one.

Time Complexity  : O(N)
Space Complexity : O(N)
*/

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
    var maxSum = Integer.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        
        dfs(root)
        
        return maxSum
    }
    
    fun dfs(node:TreeNode?):Int{
        if(node == null) return 0
        
        var left = Math.max(0, dfs(node?.left))
        var right = Math.max(0, dfs(node?.right))
        maxSum = Math.max(maxSum, left+right+node.`val`)
        
        return Math.max(left,right) + node.`val`
        
    }
}