class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var n = nums.size-1
        var res : List<List<Int>> = listOf()
        for(i in 0..n-2){
            var set = HashSet<Int>()
            for(j in i+1..n){
                if(0-nums[i]-nums[j] in set){
                    if(listOf(nums[i], nums[j], 0-nums[i]-nums[j]).sorted() in res){
                        continue
                    }
                    var temp = listOf(nums[i], nums[j], 0-nums[i]-nums[j]).sorted()
                    res += listOf(temp)
                }
                set.add(nums[j])
            }
            
        }
        return res
    }
}