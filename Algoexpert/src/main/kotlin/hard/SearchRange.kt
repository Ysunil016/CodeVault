package hard

class SearchRange {

    // O(lg(N))
    fun _searchForRange(array: List<Int>, target: Int): List<Int> {
        val finalResult = mutableListOf<Int>(-1, -1)
        alteredBinarySearch(array, 0, array.size - 1, target, finalResult, false)
        alteredBinarySearch(array, 0, array.size - 1, target, finalResult, true)
        return finalResult
    }

    private fun alteredBinarySearch(
        array: List<Int>,
        startIndex: Int,
        endIndex: Int,
        target: Int,
        finalResult: MutableList<Int>,
        left: Boolean
    ) {
        var leftIndex = startIndex
        var rightIndex = endIndex
        while (leftIndex < rightIndex) {
            val middle = (leftIndex + rightIndex) / 2
            if (array[middle] < target) {
                leftIndex = middle + 1
            } else if ((array[middle] > target)) {
                rightIndex = middle - 1
            } else {
                if (left) {
                    if (middle == 0 || array[middle - 1] != target) {
                        finalResult[0] = middle
                        return
                    } else {
                        rightIndex = middle - 1
                    }
                } else {
                    if (middle == array.size - 1 || array[middle + 1] != target) {
                        finalResult[1] = middle
                        return
                    } else {
                        leftIndex = middle + 1
                    }
                }
            }
        }
    }


    // O(N)
    private fun searchForRange(array: List<Int>, target: Int): List<Int> {
        var lowIndex = Int.MAX_VALUE
        var maxIndex = Int.MIN_VALUE
        for (i in 0 until array.size) {
            if (array[i] == target) {
                lowIndex = Math.min(i, lowIndex)
                maxIndex = Math.max(i, maxIndex)
            }
        }
        if (lowIndex == Int.MAX_VALUE)
            lowIndex = -1
        if (maxIndex == Int.MIN_VALUE)
            maxIndex = -1

        return listOf(lowIndex, maxIndex)
    }


}