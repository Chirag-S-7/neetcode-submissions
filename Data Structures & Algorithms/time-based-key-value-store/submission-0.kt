class TimeMap() {
    val mp = mutableMapOf<String, MutableMap<Int, String>>()
    fun set(key: String, value: String, timestamp: Int) {
        mp.getOrPut(key) { mutableMapOf() }[timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        if(!mp.containsKey(key)){
            return ""
        }
        val innerMp = mp[key]!!
        for(i in timestamp downTo 0){
            if(innerMp.containsKey(i)){
                return innerMp[i]!!
            }
        }
        return ""
    }
}
