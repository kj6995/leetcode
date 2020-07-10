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
    var ans: List<String> = listOf()
    fun binaryTreePaths(root: TreeNode?): List<String> {
        var list = mutableListOf<Int?>()
        var index = 0
        dfs(root,list, index)
        return ans
    }
    fun dfs(node: TreeNode?, list: MutableList<Int?>, _index: Int){
        if(node == null){
            return
        }
        list.add(_index, node.`val`)
        var index = _index + 1
        if(node.left == null && node.right == null){
            ans += list.slice(0..index-1).joinToString("->")
        }
        else{
            dfs(node.left, list, index)
            dfs(node.right, list, index)
        }
    }
}

/* Points to Note : At first it seems like index has no use and we can print the paths without using it but our list is getting modified at certain position because of it.
For e.g 

   10
  /  \
 8    2
/ \  /
3  5 2


list[0] = 10; //{10}
dfs(8, {10}, 1)
list[1] = 8; // {10, 8}
dfs{3, {10, 8}, 2)
list[2] = 3; // {10, 8, 3}
index = 3;
// now ans output gets added :- 10 8 3
//backTracks to previous call
dfs{5, {10, 8, 3}, 2)
list[2] = 5; // {10, 8, 5} here is where your doubt gets cleared. we can see that 5 overwrites 3 Giving us
the list we required
index = 3;
//now ans output  gets added :- 10 8 5
dfs{2, {10, 8, 5}, 1}
list[1] = 2; // {10, 2, 5} here 2 overwrites 8
index = 2; // what if two is a leafNode.. now we will print list array but upto the length given in the
index so the output will be :- 10 2

*/

/*
Time Complexity : O(N) as it is going throughr N Nodes
Space Complexity : O(N) Atmost it is stroing N nodes
*/