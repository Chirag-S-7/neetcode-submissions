/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true

        var slow = head
        var fast = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        var second = reverseLL(slow?.next)
        var first = head

        while (second != null) {
            if (first?.`val` != second.`val`) {
                return false
            }
            first = first?.next
            second = second.next
        }

        return true
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
