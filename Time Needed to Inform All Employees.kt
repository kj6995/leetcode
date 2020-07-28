//see the post here : https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/532560/JavaC%2B%2BPython-DFS
/*
using Bottom-up
Time Complexity  : O(N) //As we are visiting every node once
Space Compexity  : O(1) // No additional space is used and we updating the values in the given array

Using Top-Down Approach
Time Complexity  : O(N) //As we are visiting every node once
Space Complexity : O(N) //GraphMap is used to store the children for each node

Bottom-Up approach is much faster tahn top-Down as O(N) time is saved in not saving the children in a map

*/


//Using Boottom-up approach
class Solution {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        
        //var time = informTime
        //var manage = manager
        //Not sure here how manager and informTime array are allowing to change the values
        fun dfs(node: Int) : Int{
             if(manager[node] != -1){
                 informTime[node] += dfs(manager[node])
                 manager[node] = -1 
             }
             
             return informTime[node]
        }
        var res = 0
        for(i in 0..n-1){
            res = Math.max(res,dfs(i))
        }
        
        return(res)
        
    }
}

//Using Top-Down aproach
class Solution {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        //Using Top-down approach
        var graphmap = mutableMapOf<Int,MutableList<Int>>()
        fun dfs(node:Int):Int{
            var maximum = 0
            if(!graphmap.containsKey(node)) return maximum
            
            for(j in graphmap[node]!!){
                maximum = Math.max(maximum, dfs(j))
            }
            
            return maximum + informTime[node]
        }
        
        for(i in 0..manager.size-1){
            if(!graphmap.containsKey(manager[i])){
                graphmap[manager[i]] = mutableListOf<Int>()
            }
            graphmap[manager[i]]!!.add(i)
        }  
        
        return dfs(headID)
        
    }
}