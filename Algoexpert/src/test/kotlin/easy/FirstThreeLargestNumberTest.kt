package easy

import org.junit.Assert
import org.junit.Test

class FirstThreeLargestNumberTest{

    @Test
    fun shouldReturnValidThreeLargest(){
        var firstThreeLargestNumber = FirstThreeLargestNumber()
        var actualArray = firstThreeLargestNumber.findThreeLargestNumbers(listOf(141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7))
        Assert.assertArrayEquals(listOf<Int>(18, 141, 541).toIntArray(),actualArray.toIntArray())
    }

    @Test
    fun shouldReturnValidThreeLargest_(){
        var firstThreeLargestNumber = FirstThreeLargestNumber()
        var actualArray = firstThreeLargestNumber.findThreeLargestNumbers(listOf(1, 17, -7, -17, -27, 18, 541, 8, 7, 7))
        Assert.assertArrayEquals(listOf<Int>(17,18, 541).toIntArray(),actualArray.toIntArray())
    }

    @Test
    fun shouldReturnValidThreeLargest__(){
        var firstThreeLargestNumber = FirstThreeLargestNumber()
        var actualArray = firstThreeLargestNumber.findThreeLargestNumbers(listOf(141, 1, 17))
        Assert.assertArrayEquals(listOf<Int>(1, 17, 141).toIntArray(),actualArray.toIntArray())
    }

}