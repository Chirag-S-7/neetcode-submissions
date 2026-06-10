class MedianFinder {
    val mxHeap = PriorityQueue<Int>(compareByDescending{ it })
    val mnHeap = PriorityQueue<Int>()
    fun addNum(num: Int) {
        if(mnHeap.isNotEmpty() && num > mnHeap.peek()){
            mnHeap.add(num)
        } else {
            mxHeap.add(num)
        }
        
        if(mxHeap.size>mnHeap.size+1){
            mnHeap.add(mxHeap.poll())
        }
        if(mnHeap.size>mxHeap.size+1){
            mxHeap.add(mnHeap.poll())
        }
    }

    fun findMedian(): Double {
        if(mxHeap.size>mnHeap.size){
            return mxHeap.peek().toDouble()  
        } else if(mnHeap.size>mxHeap.size) {
            return mnHeap.peek().toDouble() 
        }
        else {
            return (mxHeap.peek()+mnHeap.peek())/2.0
        }
    }
}
