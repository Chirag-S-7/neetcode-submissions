class Solution {
    fun asteroidCollision(arr: IntArray): IntArray {
        val st = ArrayDeque<Int>()
        st.addFirst(arr[0])
        for(i in 1 until arr.size){
            val curr = arr[i]
            if(st.isEmpty()){
                st.addFirst(curr)
            }
            else if(curr<0 && st.first()<0){
                st.addFirst(curr)
            } else if(curr<0 && st.first()>0){
                while(st.isNotEmpty() && st.first() > 0 && abs(curr)>st.first()){
                    st.removeFirst()
                }
                if(st.isEmpty() || st.first()<0){
                    st.addFirst(curr)
                } else if(abs(curr)==st.first()){
                    st.removeFirst()
                } else {
                    
                }            
            }
            else if(curr>0){
                st.addFirst(curr)
            } 
        }
        return st.toIntArray().reversedArray()
    }
}
