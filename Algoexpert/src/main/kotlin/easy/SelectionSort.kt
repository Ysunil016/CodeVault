package easy

class SelectionSort {

    fun selectionSort(array: MutableList<Int>): List<Int> {
        var startPoint = 0
        while(startPoint < array.size){
            var counter = startPoint
            while(counter < array.size){
                val minValueIndex = getSmallestIndex(array,counter)
                val swapValue = array[minValueIndex]
                array[minValueIndex] = array[counter]
                array[counter] = swapValue
                counter++
            }
            startPoint++
        }
        return array
    }

    private fun getSmallestIndex(array: MutableList<Int>,startIndex:Int):Int{
        var minValueIndex = startIndex;
        var counter = startIndex;
        while(counter < array.size){
            if(array[counter] < array[minValueIndex]){
                minValueIndex = counter
            }
            counter++;
        }
        return minValueIndex;
    }

}