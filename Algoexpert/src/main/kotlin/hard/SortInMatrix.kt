package hard

class SortInMatrix {

    // O(nLog(m))
    fun searchInSortedMatrix(matrix: List<List<Int>>, target: Int): Pair<Int, Int> {
        val result = mutableListOf<Int>(-1, -1)
        matrix(0, 0, matrix, target, result)
        return Pair(result[0], result[1])
    }

    private fun matrix(start: Int, end: Int, matrix: List<List<Int>>, target: Int, result: MutableList<Int>) {
        if (start >= matrix.size || end >= matrix[0].size) return
        if (matrix[start][end] == target) {
            result[0] = start
            result[1] = end
        };
        matrix(start + 1, end, matrix, target, result)
        matrix(start, end + 1, matrix, target, result)
        matrix(start + 1, end + 1, matrix, target, result)
    }

    fun searchInSortedMatrix2(matrix: List<List<Int>>, target: Int): Pair<Int, Int> {
        // Write your code here.
        for (i in 0 until matrix.size) {
            val elementFound = element(matrix[i], target)
            if (elementFound != -1) {
                return Pair(i, elementFound)
            }
        }
        return Pair(-1, -1)
    }

    private fun element(array: List<Int>, target: Int): Int {
        var left = 0;
        var right = array.size
        while (left < right) {
            val middle = (left + right) / 2
            if (target < array[middle]) {
                right = middle - 1
            } else if (target > array[middle]) {
                left = middle + 1
            } else {
                return middle;
            }
        }

        if (left == right && left >= 0 && right < array.size && target == array[left])
            return left;

        return -1;
    }

}