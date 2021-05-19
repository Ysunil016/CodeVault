package medium

import kotlin.math.min

class MinNumberOfJump {

    private var result: Int = Int.MAX_VALUE

    fun minNumberOfJumps(array: List<Int>): Int {
        result = Int.MAX_VALUE
        calculate(array, 0, 0);
        return result
    }

    private fun calculate(array: List<Int>, index: Int, count: Int) {
        if (index == array.size - 1) {
            result = min(result, count)
        };
        if (index >= array.size) return;

        for (i in 1 until array[index] + 1) {
            calculate(array, index + i, count + 1)
        }
    }
}