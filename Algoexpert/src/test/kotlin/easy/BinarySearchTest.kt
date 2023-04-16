package easy

import org.junit.Assert
import org.junit.Test
class BinarySearchTest{

    @Test
    fun shouldReturnThreeIndex(){
        var bst = BinarySearch()

        val actualIndex = bst.binarySearch(listOf(0,1,21,33,45,45,61,71,72,73),33)

        Assert.assertEquals(3,actualIndex)
    }


    @Test
    fun shouldReturnFiveIndex(){
        var bst = BinarySearch()

        val actualIndex = bst.binarySearch(listOf(0,1,21,33,45,45,61,71,72,73),45)

        Assert.assertEquals(5,actualIndex)
    }

    @Test
    fun shouldReturnFourIndex(){
        var bst = BinarySearch()

        val actualIndex = bst.binarySearch(listOf(0,1,21,33,45,45,61,71,72,73),45)

        Assert.assertEquals(5,actualIndex)
    }



    @Test
    fun shouldReturnSixIndex(){
        var bst = BinarySearch()

        val actualIndex = bst.binarySearch(listOf(0,1,21,33,45,45,61,71,72,73),61)

        Assert.assertEquals(6,actualIndex)
    }

    @Test
    fun shouldReturnEightIndex(){
        var bst = BinarySearch()

        val actualIndex = bst.binarySearch(listOf(0,1,21,33,45,45,61,71,72,73),72)

        Assert.assertEquals(8,actualIndex)
    }

}