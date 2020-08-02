//Time Complexity: O(N*N) As converting grid to list is O(n^2) and swapping is also O(n^2)
//Space Complexity : O(N) as we are storing it in a list  

class Solution {
    fun minSwaps(grid: Array<IntArray>): Int {
        //Grid is valid Or not?
        //It is valid if n-1-i zeros prresent at the end in ith row
        //How to swap?
        //[0,1,2] -> [2,1,0]
        var n = grid.size
        var comp = mutableListOf<Int>()
        var ans = 0
        
        for(row in grid){
            var count = 0
            var i = n-1
            while(i > 0 && row[i] == 0){
                count++
                i--
            }
            comp.add(count)
        }
            
        //[0,1,2]
        
        for(i in 0..n-1){
            if(comp[i] < n-1-i){
                var j = i
                while(j<n && comp[j] < n-1-i){
                    j++
                }
                
                if(j == n){
                    return -1
                }
                
                while(i<j){
                    var temp = comp[j]
                    comp[j] = comp[j-1]
                    comp[j-1] = temp
                    ans++
                    j--
                }
            }
        }
        
        
        return ans
        
    }
}