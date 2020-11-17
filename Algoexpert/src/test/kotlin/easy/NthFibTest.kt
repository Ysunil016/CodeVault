package easy

import org.junit.Assert
import org.junit.Test

class NthFibTest{

    @Test
    fun shouldReturnThirteen(){
        var nthFibTest = NthFib()
        Assert.assertEquals(13,nthFibTest.getNthFib(8))
    }


    @Test
    fun shouldReturnThirteen_DP(){
        var nthFibTest = NthFib()
        Assert.assertEquals(13,nthFibTest.getNthFib_DP(8))
    }

    @Test
    fun shouldReturnTwelve(){
        var nthFibTest = NthFib()
        Assert.assertEquals(89,nthFibTest.getNthFib(12))
    }

    @Test
    fun shouldReturnTwelve_DP(){
        var nthFibTest = NthFib()
        Assert.assertEquals(89,nthFibTest.getNthFib_DP(12))
    }

    @Test
    fun shouldReturnOne(){
        var nthFibTest = NthFib()
        Assert.assertEquals(1,nthFibTest.getNthFib(2))
    }

    @Test
    fun shouldReturnOne_DP(){
        var nthFibTest = NthFib()
        Assert.assertEquals(1,nthFibTest.getNthFib_DP(2))
    }

}