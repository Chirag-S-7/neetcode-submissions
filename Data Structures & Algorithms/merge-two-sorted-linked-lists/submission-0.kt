/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1==null) return list2
        if(list2==null)return list1
        val dummy:ListNode? = ListNode(-1)
        var curr = dummy
        var h1 = list1
        var h2 = list2
        while(h1!=null && h2!=null){
            if(h1.`val`<=h2.`val`){
                curr?.next=h1
                h1=h1.next
            } else {
                curr?.next=h2
                h2=h2.next
            }
            curr = curr!!.next
        }
        while(h1!=null){
            curr?.next=h1
            h1=h1.next
            curr = curr!!.next
        }
        while(h2!=null){
            curr?.next=h2
            h2=h2.next
            curr = curr!!.next
        }
        return dummy?.next
    }
}
