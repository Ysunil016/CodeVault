package advent

import java.util.*


fun main() {
    var scanner = Scanner(System.`in`)
    var treeS = mutableListOf<String>()
    while (true) {
        var value = scanner.nextLine()
        if (value == "-1") break
        treeS.add(value)
    }
    Day_5().solve(treeS)
}
class Day_5 {


    fun solve(input: List<String>) {
        var max = 0
        val ids = mutableListOf<Int>()
        for (s in input) {
            var row = 0
            var col = 0
            for (i in 0..6) {
                if (s[i] == 'B') row += Math.pow(2.0, (6 - i).toDouble()).toInt()
            }
            for (i in 7..9) {
                if (s[i] == 'R') col += Math.pow(2.0, (9 - i).toDouble()).toInt()
            }
            val rowCol = row * 8 + col
            ids.add(rowCol)
            if (rowCol > max) max = rowCol
        }
        println("Part 1:$max")
        var lastID = -1
        ids.sortWith(Comparator { obj: Int, anotherInteger: Int? -> obj.compareTo(anotherInteger!!) })
        for (i in ids) {
            if (lastID != -1 && i - lastID == 2) {
                println("Part 2: " + (i - 1))
                break
            }
            lastID = i
        }
}

    }
