/*
Solution 1 : Note : This will give TLE try the solution 2 approach
Time COmplexity : O(NlogN)
Space COmplexuity : O(N)
*/

class Solution {
    fun lastRemaining(n: Int): Int {
        var arr = mutableListOf<Int>()
        for(i in 0..n-1) arr.add(i+1)
        
        while(arr.size > 1){
            var i = 0
            while(i <= arr.size-1 ){
                arr.removeAt(i)
                i += 1
            }  
            
            if(arr.size > 1){
                i = arr.size-1
                while(i >= 0 ){
                    arr.removeAt(i)
                    i -= 2
                } 
            }
        } 
         

        
        return arr[0]
    }
}

/*
Time omplxity    : O(logN)
Space Complexity : O(logN) for LogN stack are occupied for Recursion

Inspired by Josephus Problem
https://leetcode.com/problems/elimination-game/discuss/87120/one-line-java-solution-based-on-Josephus-Problem

recursive version
for example:
1,2,3,4,...n
if you start from the left to right, the result is i
then, if you start from right to left, the result is n+1-i
for n numbers, after one pass, there are n/2 left, each number is two times of the original,
1,2,3,4,5,6,7,8,9
after one pass
2,4,6,8
assume the result of 1,2,3,4 from left to right is f(4)
then the result of 1,2,3,4 from right to left is 5-f(4)
then the result of 2,4,6,8 from right to left is 2*(5-f(4))
this is the formula
f(n)=2(1+n/2-f(n/2))* when n is 1, of course the result is 1

Josephus Problem Video : https://www.youtube.com/watch?v=uCsD3ZGzMgE
*/

class Solution {
    fun lastRemaining(n: Int): Int {
        return if(n== 1) 1 else 2*(1 +(n/2) - lastRemaining(n/2))
    }
}