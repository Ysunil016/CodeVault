import java.util.*

class RiverSize {

    fun riverSizes(matrix: List<IntArray>): List<Int> {
        val isVisited = Array(matrix.size) {
            BooleanArray(
                matrix[0].size
            )
        }
        val finalValue: MutableList<Int> = ArrayList()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (isVisited[i][j]) continue
                val tempHolder = ArrayList<Int>()
                traverse(i, j, matrix, isVisited, tempHolder)
                if (tempHolder.size != 0) finalValue.add(tempHolder.size)
            }
        }
        finalValue.sort()
        return finalValue
    }

    private fun traverse(
        i: Int,
        j: Int,
        matrix: List<IntArray>,
        isVisited: Array<BooleanArray>,
        tempHolder: ArrayList<Int>
    ) {
        if (i >= matrix.size || j >= matrix[0].size) return
        if (i < 0 || j < 0) return
        if (matrix[i][j] == 0 || isVisited[i][j]) return
        isVisited[i][j] = true
        tempHolder.add(1)
        if (matrix[i][j] == 1) {
            traverse(i + 1, j, matrix, isVisited, tempHolder)
            traverse(i - 1, j, matrix, isVisited, tempHolder)
            traverse(i, j + 1, matrix, isVisited, tempHolder)
            traverse(i, j - 1, matrix, isVisited, tempHolder)
        }
    }
}