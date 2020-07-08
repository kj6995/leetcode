class Solution {
    fun restrictedBoundary(grid:Array<IntArray>, i : Int, j :Int, row:Int, col:Int): Int{
        var count = 0
        
        if(i > 0 && grid[i-1][j] == 1){
            count++
        }
        
        if(i < row-1 && grid[i+1][j] == 1){
            count++
        }
        
        if(j > 0 && grid[i][j-1] == 1){
            count++
        }
        
        if(j < col-1 && grid[i][j+1] == 1){
            count++
        }
        
        return count
    }
    
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var perimeter = 0
        var row = grid.size
        var col = grid[0].size
        
        for(i in 0..row-1){
            for(j in 0..col-1){
                if(grid[i][j] == 1){
                    perimeter += 4 - restrictedBoundary(grid, i,j,row,col)                }
            }
        }
        
        
        return perimeter
    }
}