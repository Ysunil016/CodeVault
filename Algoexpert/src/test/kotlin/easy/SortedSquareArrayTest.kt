package easy

import org.junit.Assert
import org.junit.Test

internal class SortedSquareArrayTest {

    @Test
    fun sortedSquaredArray() {
        val expectedArray = listOf(1, 4, 9, 16, 25, 36)
        val actualArray = SortedSquareArray().sortedSquaredArray(arrayListOf(1, 2, 3, 4, 5, 6))
        Assert.assertArrayEquals(expectedArray.toIntArray(), actualArray.toIntArray())
    }

    @Test
    fun sortedSquaredArray2() {
        val expectedArray = listOf(1, 4)
        val actualArray = SortedSquareArray().sortedSquaredArray(arrayListOf(-2, -1))
        Assert.assertArrayEquals(expectedArray.toIntArray(), actualArray.toIntArray())
    }

}