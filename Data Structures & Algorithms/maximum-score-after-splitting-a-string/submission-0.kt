class Solution {
    fun maxScore(s: String): Int {
        val n = s.length

        val prefixZeroes = IntArray(n + 1)
        val suffixOnes = IntArray(n + 1)

        for (i in 0 until n) {
            prefixZeroes[i + 1] =
                prefixZeroes[i] + if (s[i] == '0') 1 else 0
        }

        for (i in n - 1 downTo 0) {
            suffixOnes[i] =
                suffixOnes[i + 1] + if (s[i] == '1') 1 else 0
        }

        var result = 0

        for (i in 1 until n) {
            result = maxOf(
                result,
                prefixZeroes[i] + suffixOnes[i]
            )
        }

        return result
    }
}