package medium

import org.junit.Assert
import org.junit.Test


internal class ThreeSumTest {

    @Test
    fun threeNumberSum() {
        var finalR = ThreeSum().threeNumberSum(mutableListOf(12, 3, 1, 2, -6, 5, -8, 6),0)
        Assert.assertEquals(3,finalR.size)
    }
}