/* SOlution 1 : using DP
Time COmpleity  : O(n^2)
Space COmpexity : O(n^2)

So the below solution will give TLE Error

This question is similar to K-Palindrome QUestions on Geeks For Geeks which is based on Minimum Edit Distance Problem.

Edit Distance : https://www.youtube.com/watch?v=AuYujVj646Q&t=1328s

K Palindrome : https://www.geeksforgeeks.org/find-if-string-is-k-palindrome-or-not/

The main idea here is to comapre two string (one is original string and the other is reverse of that) and for  delete operation we can either delete from the original string or from the inversed string so we would have to take minimum for both cases.

At the end we would have to check if dp[m][n] <= 2*k(for this question K is 1). As we would ave to delete from both the strings 
*/

class Solution {
    fun validPalindrome(s: String): Boolean {
        var m = s.length
        var n = s.length
        var dp = Array(m+1,{IntArray(n+1)})
        
        for(i in 0..m){
            for(j in 0..n){
                if(i == 0) dp[i][j] = j
                
                else if (j == 0) dp[i][j] = i
                
                else if(s[i -1] == s[m-1-(j -1)]){
                    dp[i][j] = dp[i-1][j-1]
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1]+1, dp[i-1][j] + 1)
                }
            }
        }
        //println(dp.contentDeepToString())
        return dp[m][n] <= 2*1
        
    }
}

/*
Solution 2
Time Complexity  : O(N)
Space COmplexity : O(1)
*/
class Solution {
    fun validPalindrome(s: String): Boolean {
        if(s.length ==  0 || s.length == 1 ) return true
        var head = 0
        var tail = s.length -1
        while(head < tail){
            if(s[head] != s[tail]){
                var i = head+1
                var j = tail
                var p = head
                var q = tail-1
                
                while(i<j && s[i] == s[j]) {
                    i++
                    j--
                }
                
                while(p<q && s[p] == s[q]) {
                    p++
                    q--
                }
                return i >= j || p >= q
            }
            
            head++
            tail--
        }
        return true
        
    }
}
