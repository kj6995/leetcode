/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    fun maxDepth(root: Node?): Int {
        if(root == null){
            return 0
        }
        
        var depth = 0
        for(i in root.children){
            depth = Math.max(depth,maxDepth(i))
            //println("i:${i!!.`val`} and depth:$depth")  /remove the comment to understand how the recursion is working
        }
        
        return depth+1
    }
}