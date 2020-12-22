package advent

import java.lang.StringBuilder
import java.util.*

object Day_6 {
    var scan = Scanner(System.`in`)

    fun main(args: Array<String>) {
        var finalResult = 0

        var hashMap = HashMap<Char,Int>()
        var people = 0


        while (true) {
            val value = scan.nextLine()
            if (value == "-1") break
            if(value == ""){
                //
                    var f = 0
                for(x in hashMap){
                    if(x.value == people){
                        f++
                    }
                }

                finalResult += f
                people = 0
                hashMap.clear()
            }
            else{
                people += 1
                for(x in value){
                        hashMap[x] = hashMap.getOrDefault(x,0) + 1
                }
            }
        }

        println(finalResult)
    }
}