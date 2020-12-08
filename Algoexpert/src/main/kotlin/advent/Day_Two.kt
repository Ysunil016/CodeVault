package advent

import java.util.*

object Day_Two {
    var scan = Scanner(System.`in`)

    @JvmStatic
    fun main(args: Array<String>) {
        val arrayList = ArrayList<String>()
        var finalCount = 0
        while (true) {
            val value = scan.nextLine()
            if (value.isEmpty()) break
            arrayList.add(value)
        }
        for(str in arrayList){
            var spl = str.split(" ")
            var range = spl[0].split("-")
            var alpha = spl[1][0]
            var password = spl[2]

            val posA = password[range[0].toInt()-1]
            val posB = password[range[1].toInt()-1]


            var res = 0
            if(posA == alpha)
                res++
            if(posB == alpha)
                res++
            if(res == 1)
                finalCount++
        }
        print(finalCount)
    }
}