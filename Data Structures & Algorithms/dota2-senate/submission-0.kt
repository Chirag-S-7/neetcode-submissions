class Solution {
    fun predictPartyVictory(senate: String): String {
        val R = ArrayDeque<Int>()
        val D = ArrayDeque<Int>()
        val n = senate.length

        for (i in senate.indices) {
            if (senate[i] == 'R') {
                R.addLast(i)
            } else {
                D.addLast(i)
            }
        }

        while (R.isNotEmpty() && D.isNotEmpty()) {
            val rTurn = R.removeFirst()
            val dTurn = D.removeFirst()

            if (rTurn < dTurn) {
                R.addLast(rTurn + n)
            } else {
                D.addLast(dTurn + n)
            }
        }

        return if (R.isNotEmpty()) "Radiant" else "Dire"
    }
}
