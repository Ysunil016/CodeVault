package medium

import java.lang.Math.abs

fun main() {
    println(firstDuplicateValue(mutableListOf(2,1,5,2,3,3,4)))
}

// O(n) in terms of Space and Time
fun firstDuplicateValue(array: MutableList<Int>): Int {
    val record =  IntArray(array.size+1)
    for(x in array.indices){
        record[array[x]]++
        if(record[array[x]] > 1){
            return array[x]
        }
    }
    return -1
}

fun firstDuplicateValueNegative(array: MutableList<Int>): Int {
        for(input in array){
            var value = kotlin.math.abs(input)
            if(array[value-1] < 0) return value
            array[value - 1] *= -1
        }
        return -1
}


