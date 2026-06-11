class Solution {
    fun sortArray(nums: IntArray): IntArray {
        val n = nums.size
        fun merge(l:Int,m:Int,r:Int){
            val left = nums.sliceArray(l..m)
            val right = nums.sliceArray(m+1..r)
            var i = 0
            var j = 0
            var k = l
            while (i < left.size && j < right.size) {
                if (left[i] <= right[j]) {
                    nums[k++] = left[i++]
                } else {
                    nums[k++] = right[j++]
                }
            }
            while (i < left.size) nums[k++] = left[i++]
            while (j < right.size) nums[k++] = right[j++]

        }
        fun mergeSort(l:Int,r:Int){
            if(l>=r) return 
            val m = l+(r-l)/2
            mergeSort(l,m)
            mergeSort(m+1,r)
            merge(l,m,r)
        }
        
        mergeSort(0,n-1)
        return nums
    }
}
