/*
Time Complexity : O(N)
Space Complexity : O(1)
*/

class Solution {
    fun detectCapitalUse(word: String): Boolean {
        if(word == word.toUpperCase()) return true
        if(word == word.toLowerCase()) return true
        if(word.length > 0 && word == word[0].toUpperCase() + word.slice(1..word.length-1).toLowerCase()) return true
        
        return false
    }
}