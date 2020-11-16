package easy

import java.util.*
import kotlin.collections.HashSet

class TwoNumberSum {
    fun findTheValues(givenInputArray: IntArray, totalSum: Int): IntArray {
        var  hashSet = HashSet<Int>();
        for(x in givenInputArray){
            hashSet.add(x)
            val expectedValue = totalSum - x
            if(hashSet.contains(expectedValue) && x != expectedValue) return intArrayOf(x, expectedValue)
        }
        return IntArray(0)
    }

    fun solution2(array: IntArray,targetSum:Int):IntArray{
        for (i in array.indices) {
            for (j in array.indices) {
                if (i != j) {
                    if (array[i] + array[j] === targetSum) {
                        return intArrayOf(array[i], array[j])
                    }
                }
            }
        }
        return IntArray(0)
    }

    fun solution3(array: IntArray,targetSum:Int):List<Int>{
        array.sort()
        for(x in array){
            val expected = targetSum - x;
            if(expected != x && array.binarySearch(expected) >= 0){
                return listOf<Int>(x,expected)
            }
        }
        return emptyList()
    }

    fun solution4(array: IntArray,targetSum:Int):List<Int>{
        array.sort()
        var left = 0
        var right = array.size-1
        while(left < array.size && right >=0 && left < right){
            val foundSum = array[left]+array[right]
            if(foundSum==targetSum)
                return listOf<Int>(array[left],array[right])
            if(foundSum < targetSum){
                left++
            }else{
                right--
            }
        }
        return emptyList()
    }


}