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
    var min_hash = hashMapOf<Int?,Int?>()
    var max_hash = hashMapOf<Int?,Int?>()
    var ans = 0
    fun widthOfBinaryTree(root: TreeNode?): Int {
        
        dfs(root,0,0)
        
        return ans
    }
    
    fun dfs(root:TreeNode?, index:Int?, level:Int?){
        if(root == null){
            return
        }
        
        if(level in min_hash){
            min_hash[level] = Math.min(min_hash[level]!!, index!!)
        }else{
            min_hash[level] = index
        }
        
        if(level in max_hash){
            max_hash[level] = Math.max(max_hash[level]!!,index!!)
        }else{
            max_hash[level] = index
        }
        
        
        ans = Math.max(ans, max_hash[level]!! - min_hash[level]!! +1 )
        
        dfs(root.left, 2*index!!+1, level!!+1)
        dfs(root.right, 2*index!!+2, level!!+1)
    }
}


/*
Space-time Complexity : 
Time is O(N) as it has to visit ecvery node n the tree and

space complexity is 2*O(depth) as it has to store at least that many noides in each level  

*/