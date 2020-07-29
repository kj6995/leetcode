/*
put all te numbers in a set and then check for each number
1) how many numbers below it are present
) how many numbers above it are presnt

Since if a continuous chain of elements are present then it doesn't matter which number we are looking at we will end up covering the fll chain

Time Complexity : O(N) 
Space Complexity : O(N)
*/

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var set = mutableSetOf<Int>()
        
        nums.forEach{it -> set.add(it)}
        var maxLength = 0
        for(n in nums){
            if(set.contains(n)){
                var length = 1
                var next = n-1
                while(set.contains(next)){
                    length++
                    set.remove(next)
                    next--
                }
                next = n+1
                while(set.contains(next)){
                    length++
                    set.remove(next)
                    next++
                }
                maxLength = Math.max(maxLength,length)
            } 
        }
        
        return maxLength
    }
}

/*
Another soltuon using hashmap
the solution approach is to check the left and right values of a node if present in a hasmap and increase the length of the node by one but one thing to keep in mind is to update the boundary values. What I mean is 
since the elemets in the array can be in any order so whenever we are updating the element n then we have to also update the smallest and largest member of the chain

for e.g 1,2,0,1
for iteration 1
map is {1=1}
for iteration 2
map is {1=2,2=2,3=2} //3 won't matter but we have to update it if the net larger elemnt comes(if in place of 1,2,0,1 we had 1,2,0,3 it will get updated)
for iteration 0
map is {0=3,1=2,2=3,3=2}

so in the above map for the continuous range the bouandry values were always giving the max range value

Time Complexity : O(N)
Space Complexity : O(N)
The good thing is we are solving it in one for loop traversal
*/

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
      var map = mutableMapOf<Int,Int>()
      var result = 0
      for(n in nums){
          if(!map.containsKey(n)){
              var left = if(map.containsKey(n-1)) map.get(n-1) else 0
              var right = if(map.containsKey(n+1)) map.get(n+1) else 0
              var sum = left!! + right!! + 1
              
              map.put(n,sum)
              result = Math.max(result,sum)
              map.put(n-left,sum)
              map.put(n+right,sum)
          }                                   
      }
      
      return result
    }
}

/*
We can also do this using Quick Find Union method and treat the consecutive elements as connected components
Time Complexity : O(N * Log*N) here Log N is treated as O(1) as we are using path compression to decrease the height of the tree so it becomes O(N)

Space Complexity : O(N) as we are using parent and Size array 

*/

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var uf = UnionFind(nums.size)
        var map = mutableMapOf<Int,Int>()
        
        for(i in 0..nums.size-1){
            if(map.containsKey(nums[i])) continue
            if(map.containsKey(nums[i] - 1)) uf.union(i, map[nums[i] -1]!!)
            if(map.containsKey(nums[i] + 1)) uf.union(i, map[nums[i] +1]!!)
            map[nums[i]] = i
        }
        return uf.getLargestComponenetSize()
      
    }
}

class UnionFind(n: Int) {
    private val parent: IntArray
    private val size: IntArray

    init {
        parent = IntArray(n)
        size = IntArray(n)
        for (i in 0 until n) {
            parent[i] = i
            size[i] = 1
        }
    }
    fun union(x: Int, y: Int) { // connected if consecutive
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            if(size[rootX] < size[rootY]){
                parent[rootX] = rootY
                size[rootY] += size[rootX]
            }
            else{
                parent[rootY] = rootX
                size[rootX] += size[rootY]
            }
        }
    }

    private fun find(_x: Int): Int {
        var x = _x
        while(x != parent[x]){
            parent[x] = parent[parent[x]]
            x = parent[x]
        }
        return x
    }

    fun getLargestComponenetSize(): Int{
            var maxSize = 0
            for (i in parent.indices) {
                if (parent[i] == i && size[i] > maxSize) {
                    maxSize = size[i]
                }
            }
            return maxSize
    }
}