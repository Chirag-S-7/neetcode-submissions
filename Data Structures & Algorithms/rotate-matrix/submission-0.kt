class Solution {
    fun rotate(arr: Array<IntArray>) {
        val n = arr.size
        for(i in 0 until n){
            for(j in i+1 until n){
                arr[i][j]=arr[j][i].also{arr[j][i]=arr[i][j]}
            }
        }
        for(a in arr){
            a.reverse()
        }
    }
}
