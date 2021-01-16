package hard

import org.junit.Assert
import org.junit.Test
class SortedSubArrayKtTest {

    @Test
    fun subarraySort() {
        Assert.assertEquals(listOf(3,9),SortedSubArray().subarraySort(listOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19)))
    }
}