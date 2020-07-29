/*
Solution 1 : Using Hashmap
Time Complexity : O(N)
Space Complexity : O(N)
*/

class Solution {
    fun findTheDifference(s: String, t: String): Char {
        var map = mutableMapOf<Char,Int>()
        var ans = 'a'
        for(i in 0..s.length-1){
            map.put(s[i],map.getOrDefault(s[i],0) + 1)
            map.put(t[i],map.getOrDefault(t[i],0) - 1)
        }
        
        map.put(t[t.length-1], map.getOrDefault(t[t.length-1],0) -1)
        
        println(map)
        for(k in map.keys){
            if(map[k] == -1){ans = k}
        }
        
        return ans
    }
}

/*
Solution 2 : Using Bit Manipulation
Time Complexity  : O(N)
Space Complexity : O(1)
*/

class Solution {
    fun findTheDifference(s: String, t: String): Char {
        var ans = 0
        
        for(i in 0..s.length-1){
            ans = ans xor s[i].toInt()
        }
        
        for(j in 0..t.length-1){
            ans = ans xor t[j].toInt()
        }
        
        
        return ans.toChar()
    }
}