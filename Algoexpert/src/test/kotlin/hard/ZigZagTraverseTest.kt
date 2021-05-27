package hard

import org.junit.Assert
import org.junit.Test

internal class ZigZagTraverseTest {

    @Test
    fun zigzagTraverse() {
        val expectedList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
        val actualList = ZigZagTraverse()
            .zigzagTraverse(
                listOf(
                    listOf(1, 3, 4, 10),
                    listOf(2, 5, 9, 11),
                    listOf(6, 8, 12, 15),
                    listOf(7, 13, 14, 16)
                )
            );
        Assert.assertArrayEquals(expectedList.toIntArray(), actualList.toIntArray());
    }
}