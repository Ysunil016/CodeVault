package medium

import org.junit.Assert
import org.junit.Test

internal class SingleCycleCheckTest {

    @Test
    fun hasSingleCycle() {
    Assert.assertTrue(SingleCycleCheck().hasSingleCycle(listOf(2, 3, 1, -4, -4, 2)))
    }
    @Test
    fun hasSingleCycle_() {
        Assert.assertTrue(SingleCycleCheck().hasSingleCycle(listOf(-1,2,2)))
    }
    @Test
    fun hasSingleCycle__() {
        Assert.assertFalse(SingleCycleCheck().hasSingleCycle(listOf(1,2,1,2,1)))
    }
}