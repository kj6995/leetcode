class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var ans = IntArray(nums.size) {1}
        
        for(i in 1..nums.size-1){
            ans[i] = ans[i-1] * nums[i-1]
        }
        
        var prod = 1
        for(i in nums.size-2 downTo 0){
            prod *= nums[i+1]
            
            ans[i] = ans[i]*prod
        }
        
        return ans
    }
}