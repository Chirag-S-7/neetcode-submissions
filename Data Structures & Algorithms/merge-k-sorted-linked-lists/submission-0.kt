/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode>(compareBy{it.`val`})
        val dummy :ListNode? = ListNode(-1)
        var curr = dummy
        for(l in lists){
            l?.let{
                pq.add(it)
            }
        }
        while(pq.isNotEmpty()){
            var l = pq.poll()
            curr?.next = l
            curr = curr?.next
            l = l.next
            l?.let{
                pq.add(it)
            }
        }
        return dummy?.next
    }
}
