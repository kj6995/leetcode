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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        var start = 0
        var end = nums.size-1
        
        var root = bst(nums,start,end)
        
        return root
    }
    
    fun bst(nums:IntArray, start:Int, end:Int) : TreeNode? {
        if(start > end){
            return null
        }
        
        var mid = ((start+end)/2).toInt()
        
        var node = TreeNode(nums[mid])
        
        node.left = bst(nums, start, mid-1)
        node .right= bst(nums, mid+1, end)
        
        return node
        
    }
}