class Solution {
    fun rotate(arr: IntArray, k: Int) {
        val n = arr.size
        val k = k%n
        reverse(arr,0,n-1)
        reverse(arr,0,k-1)
        reverse(arr,k,n-1)
    }
    fun reverse(arr: IntArray, l: Int, r: Int) {
    var left = l
    var right = r

    while (left <= right) {
        arr[left] = arr[right].also { arr[right] = arr[left] }
        left++
        right--
    }
}
}
