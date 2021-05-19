package medium

import org.junit.Assert
import org.junit.Test

internal class SortStackTest{

    @Test
    fun sortStack(){
        val expectedStack = mutableListOf(-5, -2, 1, 2, 3, 4)
        val actualStack = SortStack().sortStack(mutableListOf(-5, 2, -2, 4, 3, 1))

        Assert.assertArrayEquals(expectedStack.toIntArray(),actualStack.toIntArray());
    }


}