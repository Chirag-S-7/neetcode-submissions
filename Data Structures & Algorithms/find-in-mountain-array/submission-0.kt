/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     fun get(index: Int): Int
 *     fun length(): Int
 * }
 */

class Solution {
    fun findInMountainArray(target: Int, arr: MountainArray): Int {
        val n = arr.length()
        if(n<3) return -1
        fun getPeakIndex(l:Int,r:Int):Int{
            var l = l
            var r = r
            while(l<=r){
                val mid = l+(r-l)/2
                val curr = arr.get(mid)
                val prev = if(mid-1<0) -1 else arr.get(mid-1)
                val next = if(mid+1==n) -1 else arr.get(mid+1)
                if(prev!=-1 && next!=-1 && curr>prev && curr>next){
                    return mid
                } else if(curr<next){
                    l = mid+1
                } else {
                    r = mid-1
                }
            }
            return -1
        }
        fun binarySearch(l:Int,r:Int,isReverse:Boolean):Int {
            var l = l
            var r = r
            while(l<=r){
                val mid = l+(r-l)/2
                val curr = arr.get(mid)
                if(curr==target){
                    return mid
                } else if(curr<target){
                    if(isReverse){
                        r = mid-1
                    } else {
                        l = mid+1
                    }     
                } else {
                    if(isReverse){
                        l = mid+1
                    } else {
                        r = mid-1
                    }
                }
            }
            return -1
        }
        val idx = getPeakIndex(0,n-1)
        if(arr.get(idx)==target) return idx
        val b1 = binarySearch(0,idx,false)
        val b2 = binarySearch(idx,n-1,true)
        return if(b1!=-1) b1 else if(b2!=-1) b2 else -1
    }
}
