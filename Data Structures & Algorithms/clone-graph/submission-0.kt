/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if(node==null) return null
        val map = mutableMapOf<Node,Node>()
        map[node] = Node(node.`val`)
        val q = ArrayDeque<Node>()
        q.addLast(node)
        while(q.isNotEmpty()){
            val curr=q.removeFirst()
            for(ele in curr.neighbors){
                if(!map.containsKey(ele)){
                    q.addLast(ele)
                    map[ele!!] = Node(ele.`val`)
                }
                map[curr]!!.neighbors.add(map[ele])
            }
        }
        return map[node]!!
    }
}
