package medium

import kotlin.math.abs

class SmallestDifference {

    fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
        arrayOne.sort()
        arrayTwo.sort()

        // -1 3 5 10 20 28
        // 15 17 26 134 135
        var numberFromOne = -1
        var numberFromTwo = -1
        var difference = Int.MAX_VALUE

        var indexOne = 0
        var indexTwo = 0

        while(indexOne != arrayOne.size && indexTwo != arrayTwo.size){
            val currentDifference = abs(arrayOne[indexOne] - arrayTwo[indexTwo])
            if(currentDifference < difference){
                difference = currentDifference
                numberFromOne = arrayOne[indexOne]
                numberFromTwo = arrayTwo[indexTwo]
            }
            if(arrayOne[indexOne] < arrayTwo[indexTwo]){
                indexOne ++
            }else{
                indexTwo ++
            }
        }

        return listOf(numberFromOne,numberFromTwo)
    }
}