package easy

import org.junit.Assert
import org.junit.Test

internal class ProductSumTest {


    @Test
    fun productSum() {
        var x = listOf(5,2,4,1,3)
        var expectedValue = 15

        var actualValue = ProductSum().productSum(x)

        Assert.assertEquals(expectedValue,actualValue)
    }

    @Test
    fun productSum_() {
        var x = listOf(listOf(listOf(5)))
        var expectedValue = 30

        var actualValue = ProductSum().productSum(x)

        Assert.assertEquals(expectedValue,actualValue)
    }

    @Test
    fun productSum__() {
        var x = listOf(5,2, listOf(7,-1),3, listOf(6, listOf(-13,8),4))
        var expectedValue = 12

        var actualValue = ProductSum().productSum(x)

        Assert.assertEquals(expectedValue,actualValue)
    }

    @Test
    fun productSum___() {
        var x = listOf(listOf(7,-1),listOf(6, listOf(-13,8),4))
        var expectedValue = 2

        var actualValue = ProductSum().productSum(x)

        Assert.assertEquals(expectedValue,actualValue)
    }
}