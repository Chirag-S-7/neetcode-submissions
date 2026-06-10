class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) return false

        val fq1 = IntArray(26)
        val fq2 = IntArray(26)

        var start = 0
        var end = s1.length

        for (i in s1.indices) {
            fq1[s1[i] - 'a']++
            fq2[s2[i] - 'a']++
        }

        while (end < s2.length) {
            if (fq1.contentEquals(fq2)) return true

            fq2[s2[start++] - 'a']--
            fq2[s2[end++] - 'a']++
        }

        return fq1.contentEquals(fq2)
    }
}