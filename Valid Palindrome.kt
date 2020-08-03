/* Check solution 2 it is space optimized
Solution 1
Time Complexity : O(N)
Space Complexity : O(N) As we are storing values in another string

*/
class Solution {
    fun isPalindrome(s: String): Boolean {
        var newString = s.toLowerCase().filter{(it>='a' && it <='z') || (it >= '0' && it <= '9')}
        var ans = false
        var revString = ""
        
        for(i in newString.length-1 downTo 0){
            revString += newString[i]
        }
        
        if(newString == revString){
            ans = true
        }
        println("newString:$newString")
        println("revString:$revString")
        return ans
    }
}

/*Soluton 2
Time Complexity : O(N)
Space Complexity: O(1)
*/
class Solution {
    fun Char.isAlphaNumeric() : Boolean = (this >='a' && this <= 'z') || (this >= 'A' && this <= 'Z') || (this >= '0' && this <= '9')
    
    fun isPalindrome(s: String): Boolean {
        var ans = true
        var head = 0
        var tail = s.length -1
        
        while(head < tail){
            if( !s[head].isAlphaNumeric() ) head++
            else if(!s[tail].isAlphaNumeric()) tail--
            else{
                if(s[head].toLowerCase() == s[tail].toLowerCase()){
                    head++
                    tail--
                }
                else{
                    ans = false
                    break
                }
            }
        }
        
        
        return ans
        
    }
}