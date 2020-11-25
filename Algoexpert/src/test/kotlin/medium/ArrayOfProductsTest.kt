package medium

import org.junit.Assert
import org.junit.Test

class ArrayOfProductsTest {

    @Test
    fun arrayOfProducts() {
        var expectedArray = listOf<Int>(8,40,10,20)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts(listOf(5, 1, 4, 2))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }

    @Test
    fun arrayOfProducts_() {
        var expectedArray = listOf<Int>(384, 48, 64, 192, 96)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts(listOf(1, 8, 6, 2, 4))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }
    @Test
    fun arrayOfProducts__() {
        var expectedArray = listOf<Int>(0, 0, 0, 0)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts(listOf(0,0,0,0))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }
    @Test
    fun arrayOfProducts___() {
        var expectedArray = listOf<Int>(1, 1, 1)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts(listOf(1, 1, 1, ))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }
    @Test
    fun arrayOfProducts____() {
        var expectedArray = listOf<Int>(-1, -1, -1, -1)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts(listOf(-1, -1, -1, -1))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }

    @Test
    fun arrayOfProducts_____(){
        var expectedArray = listOf<Int>(362880, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }






    @Test
    fun arrayOfProductsB() {
        var expectedArray = listOf<Int>(8,40,10,20)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts_BF(listOf(5, 1, 4, 2))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }

    @Test
    fun arrayOfProductsB_() {
        var expectedArray = listOf<Int>(384, 48, 64, 192, 96)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts_BF(listOf(1, 8, 6, 2, 4))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }
    @Test
    fun arrayOfProductsB__() {
        var expectedArray = listOf<Int>(0, 0, 0, 0)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts_BF(listOf(0,0,0,0))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }
    @Test
    fun arrayOfProductsB___() {
        var expectedArray = listOf<Int>(1, 1, 1)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts_BF(listOf(1, 1, 1, ))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }
    @Test
    fun arrayOfProductsB____() {
        var expectedArray = listOf<Int>(-1, -1, -1, -1)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts_BF(listOf(-1, -1, -1, -1))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }

    @Test
    fun arrayOfProductsB_____(){
        var expectedArray = listOf<Int>(362880, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        var arrayOfProducts = ArrayOfProducts().arrayOfProducts_BF(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))

        Assert.assertEquals(expectedArray,arrayOfProducts)
    }


}