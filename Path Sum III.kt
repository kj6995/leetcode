/*
For O(N) solution check these two links 
link1 : https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
link2 : https://leetcode.com/problems/path-sum-iii/discuss/141424/Python-step-by-step-walk-through.-Easy-to-understand.-Two-solutions-comparison.-%3A-)
*/



/*
This will give TLE as it is O(N*N) solution
Time Complexity : O(N*N)
Space Complexity : O(N)
*/
class Solution {
    private lateinit var ans : MutableList<MutableList<Int>> 
    var maxCount = 0
    fun MutableList<Int>.insert(n :  Int): MutableList<Int>{
        var result =  this.toMutableList()
        result.add(n)
        return result
    }
    
    fun pathSum(root: TreeNode?, sum: Int): Int {
        //println("root:${root!!.`val`}")
        if(root != null){
            ans = mutableListOf()
            root?.dfs(sum, mutableListOf<Int>())
            if(ans.count() > 0) maxCount += ans.count()
        }
        if(root?.left != null) pathSum(root.left, sum)
        if(root?.right != null) pathSum(root.right, sum)
        //println(ans)
        return maxCount
    }
    
    private fun TreeNode.dfs(sum : Int, path : MutableList<Int>){
        //println("path:$path and ans :$ans")
        if(sum- this.`val` == 0){
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

/*
Below one is the optimal solution
Time Complexity  : O(N)
Space Complexity : O(N)
*/


class Solution {
    
    fun pathSum(root: TreeNode?, sum: Int): Int {
        var map = mutableMapOf<Int, Int>()
        map.put(0,1)
        return dfs(root, 0,map,sum)
          
    }
    
    fun dfs(root:TreeNode?, _currsum :Int, map:MutableMap<Int,Int>, sum :Int):Int{
            if(root == null) return 0
            
            val currsum = _currsum + root.`val`
            var ans = map.getOrDefault(currsum-sum,0)
            map.put(currsum, map.getOrDefault(currsum,0) + 1)
            
            ans += dfs(root.left,currsum, map, sum) + dfs(root.right,currsum,map ,sum)
            map.put(currsum, map[currsum]!! -1)
            
            return ans
            
    }
    
}