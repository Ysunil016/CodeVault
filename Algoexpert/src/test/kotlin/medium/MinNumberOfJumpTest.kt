package medium

import org.junit.Assert
import org.junit.Test

internal class MinNumberOfJumpTest {

    @Test
    fun minNumberOfJumps() {
        val expectedValue = 4;
        val actualValue = MinNumberOfJump().minNumberOfJumps(listOf(3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3))
        Assert.assertEquals(expectedValue,actualValue)
    }

}