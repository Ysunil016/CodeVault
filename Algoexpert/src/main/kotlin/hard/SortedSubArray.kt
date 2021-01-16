package hard

import kotlin.math.max
import kotlin.math.min

class SortedSubArray {

    fun subarraySort(array: List<Int>): List<Int> {
        var minOutOfOrder = Int.MAX_VALUE;
        var maxOutOfOrder = Int.MIN_VALUE;
        for (i in 0 until array.size) {
            val num = array[i]
            if (isOutOfOrder(i, num, array)) {
                minOutOfOrder = min(minOutOfOrder, num)
                maxOutOfOrder = max(maxOutOfOrder, num)
            }
        }
        if (minOutOfOrder == Int.MAX_VALUE) return listOf<Int>(-1, -1)
        var subArrayLeft = 0
        while (minOutOfOrder >= array[subArrayLeft]) {
            subArrayLeft++
        }
        var subArrayRight = array.size - 1
        while (maxOutOfOrder <= array[subArrayRight]) {
            subArrayRight--
        }

        // Write your code here.
        return listOf<Int>(subArrayLeft, subArrayRight)
    }

    private fun isOutOfOrder(i: Int, num: Int, array: List<Int>): Boolean {
        if (i == 0) return num > array[i + 1]
        if (i == array.size - 1) return num < array[i - 1]
        return num > array[i + 1] || num < array[i - 1]
    }
}
