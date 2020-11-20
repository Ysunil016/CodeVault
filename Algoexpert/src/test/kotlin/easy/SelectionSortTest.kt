package easy

import org.junit.Assert
import org.junit.Test


class SelectionSortTest{

    @Test
    fun selectionSort_() {
        var insertion = SelectionSort()

        var expectedResult = mutableListOf<Int>(1,2,3,4,5,7,8,9)
        var actualResult = insertion.selectionSort(mutableListOf(4,3,1,2,5,8,7,9))

        Assert.assertArrayEquals(expectedResult.toIntArray(),actualResult.toIntArray())
    }

    @Test
    fun selectionSort__() {
        var insertion = SelectionSort()

        var expectedResult = mutableListOf<Int>(1,2,3,4,5,7,8,9)
        var actualResult = insertion.selectionSort(mutableListOf(1,2,3,4,5,7,8,9))

        Assert.assertArrayEquals(expectedResult.toIntArray(),actualResult.toIntArray())
    }

    @Test
    fun selectionSort___() {
        var insertion = SelectionSort()

        var expectedResult = mutableListOf<Int>(9)
        var actualResult = insertion.selectionSort(mutableListOf(9))

        Assert.assertArrayEquals(expectedResult.toIntArray(),actualResult.toIntArray())
    }
}