package easy

import org.junit.Assert
import org.junit.Test


internal class TandemBicycleTest{

    @Test
    fun tandemBicycle(){
        val expected = 21;
        val actual = TandemBicycle()
            .tandemBicycle(mutableListOf(1, 2, 3, 4, 5), mutableListOf(5, 4, 3, 2, 1),true);
        println(actual)
        Assert.assertEquals(expected,actual)
    }

}