/*
Time Complexity is O(N) for all functions
Space Complexity is O(N)
*/

class MyHashSet() {

    /** Initialize your data structure here. */
    var list = mutableListOf<Int>()

    fun add(key: Int) {
        if(!contains(key)){
            list.add(key)
        }
    }

    fun remove(key: Int) {
        for(i in 0..list.size-1){
            if(list[i] == key){
                list.removeAt(i)
                break
            }
        }
    }

    /** Returns true if this set contains the specified element */
    fun contains(key: Int): Boolean {
        if(list.size == 0) return false
        for(i in 0..list.size-1){
            if(list[i] == key){
                return true
            }
        }
        return false
    }

}