package medium

import org.junit.Test

internal class PowerSetTest {

    @Test
    fun powerSet() {
        val result = PowerSet().powerset(listOf(1, 2))
        println(result)
    }

}