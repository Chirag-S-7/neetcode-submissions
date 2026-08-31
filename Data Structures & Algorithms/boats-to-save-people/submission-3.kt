class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var l = 0
        var r = people.size-1


        var res = 0
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++
            r--
            res++
                
        }
        return res
    }
}

