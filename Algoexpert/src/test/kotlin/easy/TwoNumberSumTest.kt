package easy

import org.junit.Assert.*
import org.junit.Test

class TwoNumberSumTest{

    @Test
    fun shouldReturnArrayWithElements(){
        var twoNumberSum = TwoNumberSum()
        var givenInputArray = intArrayOf(3,5,-4,8,11,1,-1,6)
        var expectedValue = intArrayOf(-1,11)

        var actualValue = twoNumberSum.findTheValues(givenInputArray,10)

        assertEquals(2,actualValue.size)
        assertArrayEquals(expectedValue,actualValue)
    }


    @Test
    fun shouldReturnEmptyArrayWithElements(){
        var twoNumberSum = TwoNumberSum()
        var givenInputArray = intArrayOf(3,5,-4,8,11,1,-1,6)
        var expectedValue = intArrayOf()

        var actualValue = twoNumberSum.findTheValues(givenInputArray,50)

        assertEquals(0,actualValue.size)
        assertArrayEquals(expectedValue,actualValue)
    }

//    solution2

    @Test
    fun shouldReturnArrayWithElementsSol2(){
        var twoNumberSum = TwoNumberSum()
        var givenInputArray = intArrayOf(3,5,-4,8,11,1,-1,6)
        var expectedValue = intArrayOf(11,-1)

        var actualValue = twoNumberSum.solution2(givenInputArray,10)

        assertEquals(2,actualValue.size)
        assertArrayEquals(expectedValue,actualValue)
    }


    @Test
    fun shouldReturnEmptyArrayWithElementsSol2(){
        var twoNumberSum = TwoNumberSum()
        var givenInputArray = intArrayOf(3,5,-4,8,11,1,-1,6)
        var expectedValue = intArrayOf()

        var actualValue = twoNumberSum.solution2(givenInputArray,50)

        assertEquals(0,actualValue.size)
        assertArrayEquals(expectedValue,actualValue)
    }

//    solution3

    @Test
    fun shouldReturnArrayWithElementsSol3(){
        var twoNumberSum = TwoNumberSum()
        var givenInputArray = intArrayOf(3,5,-4,8,11,1,-1,6)
        var expectedValue = listOf<Int>(11,-1)

        var actualValue = twoNumberSum.solution3(givenInputArray,10)

        assertEquals(2,actualValue.size)
        assertTrue(expectedValue.containsAll(actualValue))
    }


    @Test
    fun shouldReturnEmptyArrayWithElementsSol3(){
        var twoNumberSum = TwoNumberSum()
        var givenInputArray = intArrayOf(3,5,-4,8,11,1,-1,6)
        var expectedValue = listOf<Int>()

        var actualValue = twoNumberSum.solution3(givenInputArray,50)

        assertEquals(0,actualValue.size)
        assertTrue(expectedValue.containsAll(actualValue))

    }

    // Solution 4

    @Test
    fun shouldReturnArrayWithElementsSol4(){
        var twoNumberSum = TwoNumberSum()
        var givenInputArray = intArrayOf(3,5,-4,8,11,1,-1,6)
        var expectedValue = listOf<Int>(11,-1)

        var actualValue = twoNumberSum.solution4(givenInputArray,10)

        assertEquals(2,actualValue.size)
        assertTrue(expectedValue.containsAll(actualValue))
    }


    @Test
    fun shouldReturnEmptyArrayWithElementsSol4(){
        var twoNumberSum = TwoNumberSum()
        var givenInputArray = intArrayOf(3,5,-4,8,11,1,-1,6)
        var expectedValue = listOf<Int>()

        var actualValue = twoNumberSum.solution4(givenInputArray,50)

        assertEquals(0,actualValue.size)
        assertTrue(expectedValue.containsAll(actualValue))

    }
}