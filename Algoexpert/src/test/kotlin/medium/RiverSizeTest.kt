package medium

import RiverSize
import org.junit.Test


class RiverSizeTest{

    @Test
    fun x(){
        val matrix = listOf(intArrayOf(1,0,0,1,0), intArrayOf(1,0,1,0,0), intArrayOf(0,0,1,0,1), intArrayOf(1,0,1,0,1), intArrayOf(1,0,1,1,0))
        println(RiverSize().riverSizes(matrix))
    }

}