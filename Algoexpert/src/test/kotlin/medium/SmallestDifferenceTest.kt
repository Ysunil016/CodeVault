package medium

import org.junit.Assert
import org.junit.Test

internal class SmallestDifferenceTest {

    @Test
    fun smallestDifference() {
        var expectedResult = listOf<Int>(28,26)

        var actualResult = SmallestDifference().smallestDifference(mutableListOf(-1,5,10,20,28,3), mutableListOf(26,134,135,15,17))

        Assert.assertEquals(expectedResult,actualResult)
    }

    @Test
    fun smallestDifference_() {
        var expectedResult = listOf<Int>(25, 1005)

        var actualResult = SmallestDifference().smallestDifference(mutableListOf(10, 0, 20, 25), mutableListOf(1005, 1006, 1014, 1032, 1031))

        Assert.assertEquals(expectedResult,actualResult)
    }

    @Test
    fun smallestDifference__() {
        var expectedResult = listOf<Int>(-123, -124)

        var actualResult = SmallestDifference().smallestDifference(mutableListOf(10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123), mutableListOf(-1441, -124, -25, 1014, 1500, 660, 410, 245, 530))

        Assert.assertEquals(expectedResult,actualResult)
    }

    @Test
    fun smallestDifference___() {
        var expectedResult = listOf<Int>(2000, 1032)

        var actualResult = SmallestDifference().smallestDifference(mutableListOf(10, 0, 20, 25, 2000), mutableListOf(1005, 1006, 1014, 1032, 1031))

        Assert.assertEquals(expectedResult,actualResult)
    }
}