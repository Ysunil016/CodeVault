package easy

import org.junit.Assert.*
import org.junit.Test

class ValidateSubSequenceTest{

    @Test
    fun shouldReturnFalseForSubSequence(){
        var validateSubSequence = ValidateSubSequence()
        var array :List<Int> = listOf(5,1,22,25,6,-1,8,10)
        var sequence: List<Int> = listOf(1,6,-1,10,7)

        assertFalse(validateSubSequence.isValidSubsequence(array,sequence))
    }

    @Test
    fun shouldReturnTrueForSubSequenceT(){
        var validateSubSequence = ValidateSubSequence()
        var array :List<Int> = listOf(5,1,22,25,6,-1,8,10)
        var sequence: List<Int> = listOf(1,6,-1)

        assertTrue(validateSubSequence.isValidSubsequence(array,sequence))
    }

    @Test
    fun shouldReturnTrueForSubSequence(){
        var validateSubSequence = ValidateSubSequence()
        var array :List<Int> = listOf(5,1,22,25,6,-1,8,10)
        var sequence: List<Int> = listOf(1,6,-1,10)

        assertTrue(validateSubSequence.isValidSubsequence(array,sequence))
    }

}