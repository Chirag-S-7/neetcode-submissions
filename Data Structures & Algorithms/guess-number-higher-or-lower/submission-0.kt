/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num: Int): Int
 */

class Solution : GuessGame() {
    fun guessNumber(n: Int): Int {
        var start = 1
        var end = n
        while(start<=end){
            val mid = start+(end-start)/2
            when(guess(mid)){
                0-> return mid
                1-> start = mid+1
                -1 -> end = mid-1
            }
        }
        return -1
    }
}
