class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var num = columnNumber
        val res = StringBuilder()
        while (num > 0) {
            num--
            val offset = num % 26
            res.append(('A' + offset).toChar())
            num /= 26
        }
        return res.reverse().toString()
    }
}
