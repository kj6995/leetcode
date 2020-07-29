class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var ans = false
        var i = 0
        var j = 0
        
        while(j < t.length && i < s.length){
            
            if(s[i]  == t[j]){
                i++ 
                j++
            }
            else{ j++ }
        }
        
        if(i == s.length ) ans = true
        
        return ans
    }
}