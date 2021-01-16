package leetcode

import junit.framework.Assert.assertEquals
import org.junit.Test


internal class LetterCombinationsTest {

    @Test
    fun letterCombinations() {
        assertEquals(listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf").toSet(),LetterCombinations().letterCombinations("23").toSet())
    }
}