package hard

import org.junit.Assert
import org.junit.Test

internal class SortInMatrixTest {
    @Test
    fun test() {
        val actualArray = SortInMatrix().searchInSortedMatrix(
            listOf(
                listOf(1, 4, 7, 12, 15, 1000),
                listOf(2, 5, 19, 31, 32, 1001),
                listOf(3, 8, 24, 33, 35, 1002),
                listOf(40, 41, 42, 44, 45, 1003),
                listOf(99, 100, 103, 106, 128, 1004)
            ), 44
        )
        Assert.assertArrayEquals(Pair(3, 3).toList().toIntArray(), actualArray.toList().toIntArray())
    }
}