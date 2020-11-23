package medium

import org.junit.Assert
import org.junit.Test


class MoveElementToEndTest{

    @Test
    fun shouldReturnValidArray(){
        var f = MoveElementToEnd().moveElementToEnd(mutableListOf(1,2,4,1,3,2,5,6,3,6,5,3,5,3,6,7,5),toMove = 5)

        Assert.assertArrayEquals(listOf<Int>(1, 2, 4, 1, 3, 2, 7, 6, 3, 6, 6, 3, 3, 5, 5, 5, 5).toIntArray(),f.toIntArray())
    }

    @Test
    fun shouldReturnValidArray_(){
        var f = MoveElementToEnd().moveElementToEnd(mutableListOf(1),toMove = 5)

        Assert.assertArrayEquals(listOf<Int>(1).toIntArray(),f.toIntArray())
    }

    @Test
    fun shouldReturnValidArray__(){
        var f = MoveElementToEnd().moveElementToEnd(mutableListOf(5,2,5),toMove = 5)

        Assert.assertArrayEquals(listOf<Int>(2,5,5).toIntArray(),f.toIntArray())
    }


}