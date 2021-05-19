package easy

import org.junit.Assert
import org.junit.Test

class FirstNonRepeatingCharacterTest {

    @Test
    fun firstNonRepeatingCharacter() {
        val expectedIndexValue = 1
        val actualIndexValue = FirstNonRepeatingCharacter().firstNonRepeatingCharacter("abcdcaf")
        println(actualIndexValue)
        Assert.assertEquals(expectedIndexValue,actualIndexValue)
    }

}