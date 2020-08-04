//Time Complexty : O(N)
//Space Complexxity : O(1)
class Solution {
    fun reverse(_head:ListNode?): ListNode?{
        var head = _head
        var prev : ListNode? = null
        while(head != null){
            var next = head?.next
            head.next = prev
            prev = head
            head = next
        }
        
        return prev
    }
    
    fun isPalindrome(head: ListNode?): Boolean {
        // 1 2 3 4 null
        // 1 2 3
        // null < - 3 < - 4
        
        if(head ==  null || head?.next == null) return true
        
        var first = head
        var second = head
        
        while(second != null && second.next != null){
            first = first?.next
            second = second?.next.next
        }
        
        if(second != null) first = first?.next
        
        first = reverse(first)
        second = head
        
        while(first != null){
            if(first?.`val` != second?.`val`){
                return false
            }
            first = first?.next
            second = second?.next
        }
        
        
        return true
    }
}