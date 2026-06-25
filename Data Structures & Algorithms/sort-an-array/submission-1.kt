class Solution {
    fun sortArray(arr: IntArray): IntArray {
        val n = arr.size
        fun partition(low: Int, high: Int): Int {
            val pivot = arr[low]
            var i = low
            var j = high

            while (i < j) {
                while (i <= high - 1 && arr[i] <= pivot) {
                    i++
                }

                while (j >= low + 1 && arr[j] > pivot) {
                    j--
                }

                if (i < j) {
                    arr[i] = arr[j].also { arr[j] = arr[i] }
                }
            }

            arr[low] = arr[j].also { arr[j] = arr[low] }
            return j
        }
        fun quickSort(low:Int,high:Int){
            if(low<high){
                val p = partition(low,high)
                quickSort(low,p-1)
                quickSort(p+1,high)
            }
        }
        quickSort(0,n-1)
        return arr

    }
}
