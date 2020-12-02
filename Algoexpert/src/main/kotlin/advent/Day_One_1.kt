package advent

import java.math.BigInteger
import java.util.*
import kotlin.collections.HashSet

object Day_One_1 {
    var scan = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
        val hashSet = ArrayList<Int>()
        while (true) {
            val value = scan.nextInt()
            if (value == -1) break
            hashSet.add(value)
        }
//        x + y + z = 2000
        var i = 0
        while(i < hashSet.size){
            var j = i+1
            while(j < hashSet.size){
               var k = j+1
                while(k < hashSet.size){
                    if((hashSet[i] + hashSet[j] + hashSet[k]) == 2020) {
                        println(((i * j) * k).toBigInteger())
                    }
                    k++
                }
                j++
            }
            i++
        }
    }
}