class Solution {
    fun myPow(x: Double, n: Int): Double {
        
        if(n == 0){
            return 1.0
        }
        
        var temp = myPow(x, n/2)
        if(n % 2 == 0){
            return (temp*temp)
        }else{
            if(n > 0){
                return x*temp*temp
            }
            else{
                if(x== 0.0){
                    throw Exception("x cannot be xero when n is negative")
                }
                return (temp*temp)/x
            }
        }
    }
}

/*
Can be solved using Divide and conquer technique just remeber you can optimize the solution by storing the value in temp

time complexity : O(log N) as we are storing it in a temp variable otherwise it would take O(N)
Space Complexity : O(log N) as in recursion that many stacks are created 


check this for explanation: https://stackoverflow.com/questions/26689929/power-function-using-recursion
*/