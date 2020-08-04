/*
Time Complexity : O(N)
Space COmplexity : O(1)
*/
class Solution {
    fun reverseList(_head: ListNode?): ListNode? {
        var prev : ListNode? = null
        var head = _head
        while(head != null){
            var next = head.next
            head.next = prev
            prev = head
            head = next
        }
        
        return prev
    }
}