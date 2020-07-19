/*
Time Complexity  : O(N) as we are visitng each node in the dfs so O(N)
Space Complexity : O(N+N) so O(N) as we are storing the data using map and list

Note: The main idea inside dfs function is to return true when cycle is found. And cycle is found when the node that we are processing (visited[node] = 1) has neighbour that is also processing (vsited[node] = 1)
*/


class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        var graphmap = mutableMapOf<Int, MutableList<Int>>()
        var visited = MutableList(numCourses) { 0 }
        
        (0 until numCourses).forEach{
            graphmap[it] = mutableListOf()
        }     
        
        prerequisites.forEach{pair ->
            val node = pair[0]
            val dependency = pair[1]
            graphmap[node]!!.add(dependency) 
        }
        
        fun dfs(node:Int):Boolean  {
            if(visited[node] == 1)return true
            if(visited[node] == 2) return false

            visited[node] = 1
            for(next in graphmap[node]!!){
                if(dfs(next)){
                    return true
                }
            }
            visited[node] = 2
            return false
        }
        
        
        for(i in 0..numCourses-1){
            if(dfs(i)){
                return false
            }
        }
        
        return true
    }
    
}

