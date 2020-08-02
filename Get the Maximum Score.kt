/*
Note: Since both the lists are strictly increasing we can use two pointer on each list to compare both the elements and increase the pointer for the lesser elements and store their sum in their respective variable. when both the elements are equal we can store the max of the previous sum and the surrent element and reset the sum to 0 for both.

Time Complexity : O(N)
Space Complexity : O(1)

*/

class Solution {
    fun maxSum(nums1: IntArray, nums2: IntArray): Int {
        var i = 0
        var j = 0
        var sumA :Long = 0
        var sumB :Long = 0
        var n = nums1.size
        var m = nums2.size
        var res :Long = 0
        while(i < n || j < m){
            if(i < n && (j == m || nums1[i] < nums2[j] )){
                sumA += nums1[i]
                i++
            }
            else if(j < m && (i == n || nums2[j] < nums1[i])){
                sumB += nums2[j]
                j++
            }
            else{
                res += Math.max(sumA,sumB) + nums1[i]
                sumA = 0
                sumB = 0
                i++
                j++
            }
        }
        
        
        return ((Math.max(sumA,sumB) + res)%(1000000007)).toInt()
    }
}