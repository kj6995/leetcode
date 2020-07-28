/*
For this question BFS and DFS both could be used. At first istance it may look like BFS cannot be used but BFS can used if we take a list and a value and at each node it is taking the values of their respective previous parents then when we are at theleaf node we would just have to check if both the children are null and sum == 0 

For DFS it's a bit easy just we would have to traverse in one direction first then if sum is not equal to the given sum then we would have to pop the element in the list. Also DFS solution is a bit fast and won't take that much space as we are using only 1 stack and then popping the element

*/

//BFS Solution check the one below this one as that's more elegant than this one


//Time Complexity  : O(N)
//Space Complexity : O(N)
class Solution {
    
    private fun MutableList<Int>.insert(n: Int): MutableList<Int> {
        val list = this.toMutableList()
        list.add(n)
        return list
    }
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        var ans : MutableList<MutableList<Int>> = mutableListOf()
        
        if(root== null){
            return ans
        }
        var q : MutableList<Triple<TreeNode, Int, MutableList<Int> > > = mutableListOf()
        
        q.add(Triple(root, root.`val`, mutableListOf(root.`val`)))
        
        while(q.size > 0){
            var (node,value,path) = q.removeAt(0)
            //println("value:$value and path:$path")
            if(node.left == null && node.right == null && value == sum){
                ans.add(path)
            }
            if(node.left != null){
                val valueleft = value + node.left.`val`
                q.add(Triple(node!!.left,valueleft, path.insert(node.left.`val`) ) )
            }
            if(node.right != null){
                val valueright = value + node.right.`val`
                q.add(Triple(node!!.right, valueright, path.insert(node.right.`val`) ))
            }
        }
        
        return ans
        
    }
}


//Another BFS

class Solution {
    private lateinit var ans : MutableList<MutableList<Int>> 
    private fun MutableList<Int>.insert(n: Int): MutableList<Int> {
        val list = this.toMutableList()
        list.add(n)
        return list
    }
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        ans = mutableListOf()
        root?.bfs(sum ,mutableListOf())
        return ans
    }
    
    private fun TreeNode.bfs(sum : Int , path : MutableList<Int>){
        if(this.left == null && this.right == null && sum - this.`val` == 0){
            ans.add(path.insert(this.`val`))    
        }
        
        if(this.left != null){
            this.left.bfs(sum - this.`val`, path.insert(this.`val`))
        }
        if(this.right != null){
            this.right.bfs(sum - this.`val`, path.insert(this.`val`))
        }
    }
}


//DFS solution
/*
Note: if you replace the code for MutableList with LinkedList then the code won't work. Details still not known

Time Complexity : O(N)
Space Complexity : O(N) as in recusion N stacks of memory could be used
*/

// basic dfs.
// Reuse linkedlist for path during search to improve perf.
// Or just create immutable list at each step to improve readability.
class Solution {
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val ans: MutableList<List<Int>> = mutableListOf()
        dfs(root, LinkedList(), sum, ans)
        return ans
    }

    private fun dfs(node: TreeNode?, path: LinkedList<Int>, sum: Int?, ans: MutableList<List<Int>>) {
        
        val newsum = sum - node!!.`val`
        path.add(node.`val`) //  linked list for perf improvement
        println(path)
        
        if (node.left == null && node.right == null) { // leaf
            if (newsum == 0) ans += path.toMutableList()
        } 
        else{
            if(node.left != null) dfs(node.left, path, newsum, ans)
            if(node.right != null) dfs(node.right, path, newsum, ans)
        }
        
        path.removeLast()

    }
}



