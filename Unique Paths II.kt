class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        var n = obstacleGrid.size
        var m = obstacleGrid[0].size
        
        var dp = Array(n, {IntArray(m)})
        
        if(obstacleGrid[0][0] == 1){
            return 0
        }
        
        for(i in 0..n-1){
            for(j in 0..m-1){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0
                }
                else if(i == 0 && j == 0){
                    dp[i][j] = 1
                }
                else if(i == 0 && j != 0){
                    dp[i][j] = dp[i][j-1]
                }
                else if(i != 0 && j == 0){
                    dp[i][j] = dp[i-1][j]
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
                }
            }
        }
        
        println(dp.contentDeepToString())
        return dp[n-1][m-1] 
    }
}

/*
comments : Do remember that the given input (in this case obstacleGrid) doesn't change as it is immutable so it's better to initialise a DP array than to solve it in the original array

Time complexity : O(n*m)
space complexity : O(n*m)

*/