package medium

import org.junit.Assert
import org.junit.Test

internal class BalancedBracketsTest {

    @Test
    fun isBalancedBrackets() {
        var inputString = "{{}}([]){}"
        Assert.assertEquals(true,BalancedBrackets().isBalancedBrackets(inputString))
    }

    @Test
    fun isBalancedBrackets_() {
        var inputString = "{{}}[]){}"
        Assert.assertEquals(false,BalancedBrackets().isBalancedBrackets(inputString))
    }

    @Test
    fun isBalancedBrackets__() {
        var inputString = "{{}}([({})]){}"
        Assert.assertEquals(true,BalancedBrackets().isBalancedBrackets(inputString))
    }

    @Test
    fun isBalancedBrackets___() {
        var inputString = "{{}[]){"
        Assert.assertEquals(false,BalancedBrackets().isBalancedBrackets(inputString))
    }
}