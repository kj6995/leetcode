/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var prev: Node? = null
 *     var next: Node? = null
 *     var child: Node? = null
 * }
 */

/* Comments
Take 5 cases into consideration:, If te node is/has
1) null : then return null
2) no child, No Next : No need to flatten and traverse, just return head
3) No child, Next : No need to flatten, just traverse
4) Child, No Next : Flatten the child and then it's done
5) Child, Next : Flatten and then connect with the next
*/
class Solution {
    fun flatten(root: Node?): Node? {
        recursion(root)
        
        return root
    }
    
    fun recursion(head: Node?):Node? {
        if(head == null) return head // Case1
        
        if(head.child == null){
            if(head.next == null){
                return head //case2
            }
            return recursion(head.next) //Case3
        }
        else{
            var child = head.child
            head.child = null
            var next = head.next
            var childtail = recursion(child)
            head.next = child
            child!!.prev = head
            if(next != null){
                childtail!!.next = next
                next!!.prev = childtail
                return recursion(next) //case5
            }
            
            return childtail //Case4
        }
    }
}


/*
Time Complexity : O(N) : As it is visting eac and every Node
Space Complexity : O(1) though we are using recusrion so O(N) : Confused here
*/