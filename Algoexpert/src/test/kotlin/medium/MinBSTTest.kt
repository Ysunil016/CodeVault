package medium

import org.junit.Assert
import org.junit.Test

internal class MinBSTTest {

    @Test
    fun minHeightBst() {
        var list = listOf<Int>(1,2,5,7,10,13,14,15,22)

        var expectedBst = MinBstO(10)

        var actualBst = MinBST().minHeightBst(list)

        Assert.assertEquals(expectedBst,actualBst)
    }
}