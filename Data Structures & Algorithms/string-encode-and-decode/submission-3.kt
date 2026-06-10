class Solution {

    fun encode(strs: List<String>): String {
    if (strs.isEmpty()) return "\u20B8" 
    return strs.joinToString("₹")
}

fun decode(str: String): List<String> {
    if (str == "\u20B8") return emptyList()
    return str.split("₹")
}
}
