/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var groupPrev: ListNode? = dummy

        while (true) {
            val kth = getKth(groupPrev, k)
            if (kth == null) {
                break
            }
            val groupNext = kth.next

            var prev: ListNode? = groupNext
            var curr = groupPrev!!.next
            while (curr != groupNext) {
                val tmp = curr!!.next
                curr.next = prev
                prev = curr
                curr = tmp
            }

            val tmp = groupPrev.next
            groupPrev.next = kth
            groupPrev = tmp
        }
        return dummy.next
    }

    private fun getKth(curr: ListNode?, k: Int): ListNode? {
        var curr = curr
        var k = k
        while (curr != null && k > 0) {
            curr = curr.next
            k--
        }
        return curr
    }
}
