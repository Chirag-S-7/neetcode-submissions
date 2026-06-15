class Solution {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        val n = words.size
        val prefix = IntArray(n + 1)

        for (i in 0 until n) {
            prefix[i + 1] = prefix[i]

            if (
                words[i].first() in vowels &&
                words[i].last() in vowels
            ) {
                prefix[i + 1]++
            }
        }

        val result = IntArray(queries.size)

        for (i in queries.indices) {
            val l = queries[i][0]
            val r = queries[i][1]

            result[i] = prefix[r + 1] - prefix[l]
        }

        return result
    }
}