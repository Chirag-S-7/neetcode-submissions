/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if(head==null) return true
        var slow = head
        var fast = head
        var prev:ListNode?=null
        while(fast!=null && fast?.next!=null){
            prev=slow
            slow=slow?.next
            fast=fast.next?.next
        }
        var curr1=head
        prev?.next=null
        var curr2 = reverseLL(slow)
        while(curr1!=null && curr2!=null){
            if(curr1.`val` != curr2.`val`){
                return false
            }
            curr1=curr1.next
            curr2=curr2.next
        }
        if(curr1==null &&(curr2==null || curr2?.next==null)){
            return true
        }
        if(curr2==null &&(curr1==null || curr1?.next==null)){
            return true
        }
        return false
    }
    private fun reverseLL(head:ListNode?):ListNode?{
        var curr = head
        var prev:ListNode? = null 
        while(curr!=null){
            var next = curr.next
            curr.next=prev
            prev=curr
            curr=next
        }
        return prev
    }
}
