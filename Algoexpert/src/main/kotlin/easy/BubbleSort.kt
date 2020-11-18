package easy

class BubbleSort {

    fun bubbleSort(array: MutableList<Int>): List<Int> {
        var i=0
        while(i<array.size){
            var j = 0
            while(j < array.size-1){
                if(array[j] > array[j+1]){
                    var temp = array[j]
                    array[j] = array[j+1]
                    array[j+1] = temp
                }
                j++
            }
            i++
        }
        return array
    }

    fun bubbleSort_(array: MutableList<Int>): List<Int> {
        var i=0
        while(i<array.size){
            var j = 0
            var isSorted = true
            while(j < array.size -1){
                if(array[j] > array[j+1]){
                    var temp = array[j]
                    array[j] = array[j+1]
                    array[j+1] = temp
                    isSorted = false
                }
                j++
            }
            if(isSorted) return array
            i++
        }
        return array
    }
}