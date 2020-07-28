/*
This question is solved using monotonic stack, I was trying to store the pop elements in a list and then return the output 
as (arr.max() - arr.min() + 2) this approach was working for some cases. Try these two test cases and you will get why the abocve approach won't work [1,3,2,2,2] ans [1,3,2,3,3]. SO the below approach is used where we are keeping two pointers e and s where e's value is increased whenever there is a pop also note if the popped element is greater than the reamining elemnts in the array then we need to place that popped elemnt in the end, right? so we do that by keeping track of the maxvalue and updating the e pointer.

Dry run the above two test cases and you will get it.

Time Complexity : O(N)
Space Complexity : O(N)
*/


class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        var stack = mutableListOf<Int>()
        var s = nums.size
        var e = 0
        var maxV = nums[0]
        
        fun peek():Int{
            return stack[stack.size-1]
        }
        
        fun pop():Int{
            return stack.removeAt(stack.size-1)
        }
        
        for(i in nums.indices){
            maxV = Math.max(maxV, nums[i])
            while(!stack.isEmpty() &&  nums[i] < nums[peek()]  ){
                s = Math.min(s, peek())
                e = i
                pop()
                
            } 
            stack.add(i)
            if(maxV > nums[i]) e = i
        }
        
        
        return Math.max(e-s+1, 0)
    }
}