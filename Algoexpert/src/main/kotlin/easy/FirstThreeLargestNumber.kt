package easy

class FirstThreeLargestNumber {
    fun findThreeLargestNumbers(array: List<Int>): List<Int> {
        var firstElement = Int.MIN_VALUE
        var secondElement = Int.MIN_VALUE
        var thirdElement = Int.MIN_VALUE

        var i=0
        while(i < array.size){
            if(array[i] > firstElement){
                thirdElement = secondElement
                secondElement = firstElement
                firstElement = array[i]
            }else if(array[i] > secondElement){
                thirdElement = secondElement
                secondElement = array[i]
            }else if(array[i] > thirdElement){
                thirdElement = array[i]
            }
            i++
        }
        return listOf(thirdElement,secondElement,firstElement)
    }

}