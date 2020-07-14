class Solution {
    fun countSmaller(nums: IntArray): List<Int> {
        
        var x = nums.toList()
        var n = nums.size
        
        //This part is added to deal with the negative numbers and == 0 condition because 0 will give TLE so 0 is also included
        var minimum = (nums.min()?:0)
        if(minimum <=  0){
            
            x = x.map{it+(-minimum+1)}
        }
        
        
        var bitsize = (x.max() ?: 0) +1 //Take additionlal as it doesn't hurt you
        var bit = MutableList(bitsize+1){0}
        var ans = mutableListOf<Int>()
        
        fun update(_index : Int, value:Int){
            var index = _index
            while(index < bitsize){
                bit.set(index, bit[index] + value)
                index += index and -index
            }
        }
        
        fun query(_index:Int):Int{
            var index = _index
            var su = 0
            while(index > 0){
                su += bit[index]
                index -= index and -index
            }
            return su
        }
        
        //We are checking the value from the right side of the array and then first querying in the BIT and then updating the values
        for(k in n-1 downTo 0){
            ans.add(0, query(x[k]-1))
            update(x[k],1)
        }
        
        
        return ans
    }
}

/*
Comments : Use Binary Index Tree just carefullly deal with the ranges

Time Complexity  : O(NlogN) As query and update both takes log N time and each operation is performed for N nodes
Space Complexity : O(maxofNum) as We need to store the value in the BIT array till the max value so roughly we can say it is O(N)
*/