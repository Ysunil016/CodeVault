package medium

import org.junit.Assert
import org.junit.Test


internal class KadanesAlgorithmTest {

    @Test
    fun kadanesAlgorithm() {
        var expectedSum = 19

        var actualSum = KadanesAlgorithm().kadanesAlgorithm(listOf(3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4))

        Assert.assertEquals(expectedSum,actualSum)
    }

    @Test
    fun kadanesAlgorithm__() {
        var expectedSum = 34

        var actualSum = KadanesAlgorithm().kadanesAlgorithm(listOf(1, 2, 3, 4, 5, 6, -22, 7, 8, 9, 10))

        Assert.assertEquals(expectedSum,actualSum)
    }

    @Test
    fun kadanesAlgorithm_() {
        var expectedSum = 101

        var actualSum = KadanesAlgorithm().kadanesAlgorithm(listOf(3, 4, -6, 7, 8, -15, 100))

        Assert.assertEquals(expectedSum,actualSum)
    }
}