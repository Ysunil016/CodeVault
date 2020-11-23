package medium

class MoveElementToEnd {
    fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
        var start = 0
        var end = array.size - 1
        while(start <= end){
            while(end > start && array[end] == toMove){
                end--
            }
            if(end == start) return array
            if(array[start] == toMove){
                var swap = array[start]
                array[start] = array[end]
                array[end] = swap
                end --
            }
            start++
        }
        return array
    }
}