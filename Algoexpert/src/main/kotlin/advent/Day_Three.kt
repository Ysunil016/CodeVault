package advent

import java.util.*

object Day_Three {
    var scan = Scanner(System.`in`)

    @JvmStatic
    fun main(args: Array<String>) {
        val arrayList = ArrayList<String>()
        var row = 0
        while (true) {
            val value = scan.nextLine()
            if (value.isEmpty()) break
            arrayList.add(value)
            row++
        }

        var right = arrayList[0].length - 1

        var result = Array(row) { List<String>(right) {"."} }
        for(i in 0 until arrayList.size){
            result[i] = arrayList[i].split("").subList(1,right)
        }

        var finalRe = 0

        var row_ = 0
        var col_ = 0
        for(r in result){
            col_ += 3
            row_ += 1
            col_ %= right
            if(result[row_][col_] == "#"){
                finalRe++
                print(result[row_])
                println(finalRe)
            }

        }
    }
}