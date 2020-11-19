package easy

import org.junit.Assert
import org.junit.Test


internal class InsertionTest {

    @Test
    fun insertionSort() {
        var insertion = Insertion()

        var expectedResult = mutableListOf<Int>(1,2,3,4,5,7,8,9)
        var actualResult = insertion.insertionSort(mutableListOf(4,3,1,2,5,8,7,9))

        Assert.assertArrayEquals(expectedResult.toIntArray(),actualResult.toIntArray())
    }

    @Test
    fun insertionSort_() {
        var insertion = Insertion()

        var expectedResult = mutableListOf<Int>(1,2,3,4,5,7,8,9)
        var actualResult = insertion.insertionSort(mutableListOf(1,2,3,4,5,7,8,9))

        Assert.assertArrayEquals(expectedResult.toIntArray(),actualResult.toIntArray())
    }

    @Test
    fun insertionSort__() {
        var insertion = Insertion()

        var expectedResult = mutableListOf<Int>(9)
        var actualResult = insertion.insertionSort(mutableListOf(9))

        Assert.assertArrayEquals(expectedResult.toIntArray(),actualResult.toIntArray())
    }
}