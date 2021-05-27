package hard

import org.junit.Assert
import org.junit.Test

internal class SearchRangeTest {

    @Test
    fun test() {
        val actualRange = SearchRange()._searchForRange(listOf(0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73), 45)
        Assert.assertArrayEquals(listOf(4, 9).toIntArray(), actualRange.toIntArray())
    }

}