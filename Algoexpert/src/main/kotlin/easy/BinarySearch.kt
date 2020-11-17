package easy

class BinarySearch {

    fun binarySearch(array: List<Int>, target: Int): Int {
        var low = 0
        var high = array.size
        while(low < high){
            val midElement = low + (high - low)/2
            if(array[midElement]==target)
                return midElement
            if(target > array[midElement]){
                low = midElement + 1
            }else{
                high = midElement
            }
        }
        return -1
    }

}