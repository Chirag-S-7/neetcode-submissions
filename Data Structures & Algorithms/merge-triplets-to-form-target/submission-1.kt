class Solution {
    fun mergeTriplets(arr: Array<IntArray>, t: IntArray): Boolean {
        var one = false
        var two = false
        var three = false
        for(a in arr){
            if (a[0] > t[0] || a[1] > t[1] || a[2] > t[2]) continue
            if (a[0] == t[0]) {
                one = true
            }

            if (a[1] == t[1]) {
                two = true
            }

            if (a[2] == t[2]) {
                three = true
            }
        }
        return one&&two&&three
    }
}
