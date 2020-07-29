/*
Time Complexity : O(N)
Space Compleity : O(N)
*/

class Solution {
    fun firstUniqChar(s: String): Int {
        var mapFreq = mutableMapOf<Char,Int>()
        var mapIndex = mutableMapOf<Char,Int>()
        for(i in 0..s.length-1){
            mapFreq.put(s[i] , mapFreq.getOrDefault(s[i],0)+1) 
            if(!mapIndex.containsKey(s[i])) mapIndex.put(s[i],i) 
        }
        var minIndex = s.length
        for(k in mapFreq.keys){
            if(mapFreq[k] == 1){
                minIndex = Math.min(minIndex, mapIndex[k]!!)
            }
        }
        
        return if(minIndex == s.length) -1 else minIndex
    }
}