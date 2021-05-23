package medium

import org.junit.Test

internal class NextGreaterElementTest {

    @Test
    fun maxElement() {
        val array = NextGreaterElement().nextGreaterElement(mutableListOf(5, 6, 1, 2, 3, 4))
        println(array)
    }

}