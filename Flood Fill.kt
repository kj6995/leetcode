class Solution {
    var path = listOf(0,1,0,-1,0)
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        if(image[sr][sc] == newColor) return image
        
        var m = image.size -1
        var n = image[0].size -1
        
        dfs(image, sr, sc, n, m, image[sr][sc], newColor)
        
        return image
    }
    fun dfs(image:Array<IntArray>, r:Int, c:Int, n:Int, m:Int, orgColor:Int, newColor:Int) {
        if(r < 0 || r > m || c < 0 || c > n) return
        if(image[r][c] != orgColor) return
        
        image[r][c] = newColor
        
        for(i in 0..3){
            dfs(image, r+path[i], c+path[i+1], n, m, orgColor, newColor)
        }
    }
}