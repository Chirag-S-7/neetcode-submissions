/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(ll1: ListNode?, ll2: ListNode?): ListNode? {
        var dummy:ListNode? = ListNode(-1)
        var head = dummy
        var sum = 0
        var carry = 0
        var l1 = ll1
        var l2 = ll2
        while(l1!=null && l2!=null){
            sum = l1.`val`+ l2.`val`+carry
            carry = sum/10
            dummy?.next = ListNode(sum%10)
            dummy = dummy?.next
            l1=l1.next
            l2=l2.next
        }
        while(l1!=null){
            sum = l1.`val`+carry
            carry = sum/10
            dummy?.next = ListNode(sum%10)
            dummy = dummy?.next
            l1=l1.next
        }
        while(l2!=null){
            sum = l2.`val`+carry
            carry = sum/10
            dummy?.next = ListNode(sum%10)
            dummy = dummy?.next
            l2=l2.next
        }
        if(carry>0){
            dummy?.next = ListNode(carry)
        }
        return head?.next
    }
}
