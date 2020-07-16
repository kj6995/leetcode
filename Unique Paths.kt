class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        var dp = Array(n, {IntArray(m)}) // where m is the no of columns and n is the no of rows
        //println(dp.size)
        //println(dp[0].size)
        for(j in 0..m-1){
            dp[0][j] = 1
        }
        
        for(i in 0..n-1){
            dp[i][0] =1
        }
        
        for(i in 1..n-1){
            for(j in 1..m-1){
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }
        }
        
        //println(dp.contentDeepToString())
        return dp[n-1][m-1]
    }
}

/*
SOlved using DP

Time : O(m*n)
Space: O(m*n)

*/