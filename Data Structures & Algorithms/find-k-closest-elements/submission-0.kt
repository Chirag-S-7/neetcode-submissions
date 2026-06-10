class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var r = arr.lowerBound(x)
        var l = r-1
        var count = 0
        val result = mutableListOf<Int>()
        while(l>=0 && r<arr.size){
            if(abs(arr[l]-x)<=abs(arr[r]-x)){
                result.add(arr[l])
                l--
            }else{
                result.add(arr[r])
                r++
            }
            count++
            if(count==k) break
        }
        while(l>=0 && count<k){
                result.add(arr[l])
                l--
                count++
        }
        while(r<arr.size && count<k){
                result.add(arr[r])
                r++
                count++
        }
        return result.sorted()
    }

    fun IntArray.lowerBound(target: Int): Int {
        var left = 0
        var right = size

        while (left < right) {
            val mid = left + (right - left) / 2

            if (this[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
