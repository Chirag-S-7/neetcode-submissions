class Solution {
    class DSU(n: Int) {
        private val parent = IntArray(n) { it }
        private val size = IntArray(n) { 1 }

        fun find(node: Int): Int {
            if (parent[node] == node) {
                return node
            }

            parent[node] = find(parent[node])
            return parent[node]
        }

        fun union(u: Int, v: Int) {

            val pu = find(u)
            val pv = find(v)

            if (pu == pv) return

            if (size[pu] < size[pv]) {
                parent[pu] = pv
                size[pv] += size[pu]
            } else {
                parent[pv] = pu
                size[pu] += size[pv]
            }
        }
    }
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val n = accounts.size
        val dsu = DSU(n)
        val emailToAcc = mutableMapOf<String, Int>()
        for (i in 0 until n) {
            for (j in 1 until accounts[i].size) {
                val email = accounts[i][j]
                if (email in emailToAcc) {
                    dsu.union(i, emailToAcc[email]!!)
                } else {
                    emailToAcc[email] = i
                }
            }
        }
        val emailGroup = mutableMapOf<Int, MutableList<String>>()
        for ((email, accId) in emailToAcc) {
            val leader = dsu.find(accId)
            emailGroup.getOrPut(leader) { mutableListOf() }.add(email)
        }
        val res = mutableListOf<List<String>>()
        for ((accId, emails) in emailGroup) {
            val name = accounts[accId][0]
            emails.sort()
            res.add(listOf(name) + emails)
        }

        return res
    }
}
