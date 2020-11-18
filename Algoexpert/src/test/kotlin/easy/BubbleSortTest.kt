package easy

import org.junit.Assert
import org.junit.Test

class BubbleSortTest{

    @Test
    fun shouldReturnSorted(){
        var sorted = BubbleSort()
        var mList = mutableListOf<Int>(4,7,1,3,9,5,7)
        var actual = sorted.bubbleSort(mList)

        var expected = mutableListOf<Int>(1,3,4,5,7,7,9)
        Assert.assertArrayEquals(expected.toIntArray(),actual.toIntArray())
    }

    @Test
    fun shouldReturnSorted_(){
        var sorted = BubbleSort()
        var mList = mutableListOf<Int>(4,7,1,3,9,5,7)
        var actual = sorted.bubbleSort_(mList)

        var expected = mutableListOf<Int>(1,3,4,5,7,7,9)
        Assert.assertArrayEquals(expected.toIntArray(),actual.toIntArray())
    }

    @Test
    fun shouldReturnSortedO(){
        var sorted = BubbleSort()
        var mList = mutableListOf<Int>(3,3,3,2,2,1,0)
        var actual = sorted.bubbleSort(mList)

        var expected = mutableListOf<Int>(0,1,2,2,3,3,3)
        Assert.assertArrayEquals(expected.toIntArray(),actual.toIntArray())
    }

    @Test
    fun shouldReturnSortedO_(){
        var sorted = BubbleSort()
        var mList = mutableListOf<Int>(0)
        var actual = sorted.bubbleSort_(mList)

        var expected = mutableListOf<Int>(0)
        Assert.assertArrayEquals(expected.toIntArray(),actual.toIntArray())
    }


}