/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }


1 2 3 4 5 6 7 8    n = 4



 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast = head
        var slow = head
        var count = n
        while(count>0 && fast!=null){
            fast=fast?.next
            count--
        }
        if(fast==null){
            return head?.next
        }
        while(fast?.next!=null){
            fast=fast?.next
            slow=slow?.next
        }
        slow?.next = slow?.next?.next
        return head

    }
}
