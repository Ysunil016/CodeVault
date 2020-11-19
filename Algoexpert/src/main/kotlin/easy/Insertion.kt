package easy

class Insertion {

    fun insertionSort(array: MutableList<Int>): List<Int> {
        for(i in array.indices){
            var j = i
            while(j >= 1 && array[j-1]>array[j]){
                var swap = array[j]
                array[j] = array[j-1]
                array[j-1] = swap
                j--;
            }
        }
        return array
    }

}